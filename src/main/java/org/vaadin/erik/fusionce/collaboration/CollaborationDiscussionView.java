package org.vaadin.erik.fusionce.collaboration;

import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;
import org.apache.commons.lang3.StringUtils;

import static org.vaadin.erik.fusionce.Application.USER_ATTRIBUTE;

/**
 * A view for chatting and collaborating.
 *
 * It is exported through the {@link CollaborationDiscussionExporter}, so that it can be used as a web component
 * inside a Fusion view.
 */
public class CollaborationDiscussionView extends VerticalLayout {

    private final CollaborationMessageList messageList;
    private final H1 header;

    public CollaborationDiscussionView() {
        String username = (String) VaadinSession.getCurrent().getAttribute(USER_ATTRIBUTE);
        UserInfo userInfo = new UserInfo(username, username);

        messageList = new CollaborationMessageList(userInfo, null);
        CollaborationMessageInput input = new CollaborationMessageInput(messageList);

        header = new H1();
        setHeader(null);

        add(header, messageList, input);
        expand(messageList);
        getStyle().set("border", "1px solid gray");
    }

    public void setTopic(String topic) {
        messageList.setTopic(topic);
        setHeader(topic);
    }

    private void setHeader(String topic) {
        header.setText(StringUtils.isNotBlank(topic) ? "Chatting about " + topic : "No topic selected");
    }
}
