# Collaboration Engine with Fusion demo

This application demos using the Vaadin Collaboration Engine in a Fusion project using the `WebComponentExporter`.

The Flow component `CollaborationDiscussionView` uses the Collaboration Engine, and is exported
as a web component through the `CollaborationDiscussionExporter`.

The `collaboration-view` includes the exported `collaboration-discussion` component.

The `webpack.config.js` is altered to make the exported component and the Fusion app use the same JavaScript bundle.
Otherwise there will be errors with multiple web component registrations for the same name.

The current user is set on session initialization through the `Application` class.

**Note:** After starting the app with `mvn` or by running the `Application` class, a hard reload may be required for the app to function.

