package runix.noteread.adapter;

import com.airbnb.epoxy.EpoxyAdapter;

import runix.noteread.adapter.model.ContentModel;
import runix.noteread.adapter.model.HeaderModel;

/**
 *
 */

public class RecyclerAdapter extends EpoxyAdapter{

    private HeaderModel mHeaderModel;
    private ContentModel mContentModel;

    public RecyclerAdapter(){
        mHeaderModel=new HeaderModel();
        addModels(mHeaderModel);
        mContentModel=new ContentModel();
        addModels(mContentModel);

    }
}
