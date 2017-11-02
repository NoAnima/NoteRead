package runix.noteread.adapter;

import android.content.Context;
import android.net.Uri;

import com.airbnb.epoxy.EpoxyAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import runix.noteread.adapter.model.ImageModel;

/**
 * @author mabo
 */

public class PhotoAdapter extends EpoxyAdapter {
    private ImageModel mImageModel;
    private String path;
    private Context context;
    public PhotoAdapter(Context context,String path){
        this.context=context;
        this.path=path;
        List<String> paths= getImagePath();
        for (String images :paths){
            mImageModel=new ImageModel(images,context);
            addModels(mImageModel);
        }
    }

    private List<String> getImagePath(){
        List<String> list=new ArrayList<>();
        File file =new File(path);
        if (file.exists()){
            File [] files =file.listFiles();
            if (files.length>0){
                for (int i=0;i<files.length;i++){
                    String imagePath=files[i].getPath();
                    list.add(imagePath);
                }
            }
        }
        return  list;
    }
}
