package runix.noteread.adapter.model;

import com.airbnb.epoxy.EpoxyModelWithHolder;

import runix.noteread.R;

/**
 *
 */

public class ContentModel extends EpoxyModelWithHolder<ContentViewHolder> {
    public ContentModel(){}
    @Override
    protected ContentViewHolder createNewHolder() {
        return new ContentViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.content_model;
    }

    @Override
    protected int getViewType() {
        return super.getViewType();
    }
}
