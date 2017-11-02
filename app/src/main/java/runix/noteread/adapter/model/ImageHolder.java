package runix.noteread.adapter.model;

import android.view.View;
import android.widget.ImageView;

import com.airbnb.epoxy.EpoxyHolder;

import runix.noteread.R;

/**
 * @author  mabo
 */

public class ImageHolder extends EpoxyHolder {

    private ImageView mImageView;
    @Override
    protected void bindView(View itemView) {
        mImageView= (ImageView) itemView.findViewById(R.id.iv_image_model);
    }
    public ImageView getImageView(){
        return mImageView;
    }
}
