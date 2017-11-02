package runix.noteread;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import runix.noteread.adapter.PhotoAdapter;

public class PhotoActivity extends AppCompatActivity {
    ImageView imageView;
    RecyclerView mRecycler;
    Uri uri;
    private EditText mSou;
    private String path = Environment.getExternalStorageDirectory()+"/noteRead/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo);

        mSou= (EditText) findViewById(R.id.et_photo_sou);

        Button button= (Button) findViewById(R.id.btn_photo);
        imageView= (ImageView) findViewById(R.id.iv_photo_show);
        mRecycler= (RecyclerView) findViewById(R.id.photo_recycler);
        initRecycler();
        String state= Environment.getExternalStorageState();


        if (state.equals(Environment.MEDIA_MOUNTED)){
            File file=new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 toPhoto();
            }
        });

        mSou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(PhotoActivity.this,SeachActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        Uri uri;
        if (requestCode==1&&data!=null){

             uri= data.getData();
            Glide.with(this).load(uri).into(imageView);
        }else {
            File file =new File(path);
            Log.i("file",":"+file.exists());
            File [] files=file.listFiles();
            Log.i("files",":"+files.length);
            for (int i=0;i<files.length;i++){
                Log.i("files",i+":"+files[i].getName());
            }

            Glide.with(this).load(mfile).into(imageView);
        }

    }
    File mfile;
    private void toPhoto(){

        String fileName = getPhotoFileName() + ".png";
        mfile=new File(path + fileName);
        Intent it =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        uri=FileProvider.getUriForFile(this,getPackageName()+".provider",mfile);

        it.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(it,1);
    }

    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return "IMG_" + dateFormat.format(date);

    }
    private void  initRecycler(){
        mRecycler.setHasFixedSize(false);
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecycler.setAdapter(new PhotoAdapter(this,path));
        mRecycler.setItemAnimator(new DefaultItemAnimator());
    }
}
