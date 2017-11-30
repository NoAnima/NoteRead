package runix.noteread.adapter.model;

import com.airbnb.epoxy.EpoxyModelWithHolder;

import runix.noteread.R;

/**
 * @author mabo
 */

public class HeaderModel  extends EpoxyModelWithHolder<HeaderViewHolder>{


    public HeaderModel(){

    }

    @Override
    protected HeaderViewHolder createNewHolder() {
        return new HeaderViewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.header_model;
    }
}
