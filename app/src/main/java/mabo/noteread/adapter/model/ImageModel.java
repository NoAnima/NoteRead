package runix.noteread.adapter.model;

import android.content.Context;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.bumptech.glide.Glide;

import runix.noteread.R;

/**
 * @author  mabo
 */

public class ImageModel extends EpoxyModelWithHolder<ImageHolder> {


    private String mImagePath;
    private Context mContext;
    public ImageModel(String imagePath, Context context){
        this.mContext=context;
        this.mImagePath=imagePath;
    }

    @Override
    protected ImageHolder createNewHolder() {
        return new ImageHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return  R.layout.image_model;
    }

    @Override
    public void bind(ImageHolder holder) {
        super.bind(holder);
        Glide.with(mContext).load(mImagePath).into(holder.getImageView());
    }
}
