package org.vaadin.erik.fusionce.collaboration;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.webcomponent.WebComponent;

/**
 * @author erik@vaadin.com
 * @since 4/27/21
 */
@Push
public class CollaborationDiscussionExporter extends WebComponentExporter<CollaborationDiscussionView> {

    public static final String TAG = "collaboration-discussion";

    public CollaborationDiscussionExporter() {
        super(TAG);
        addProperty("topic", "").onChange(CollaborationDiscussionView::setTopic);
    }

    @Override
    protected void configureInstance(WebComponent<CollaborationDiscussionView> webComponent, CollaborationDiscussionView component) {
        // No-op
    }
}
