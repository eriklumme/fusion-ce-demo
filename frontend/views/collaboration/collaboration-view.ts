import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import {customElement, html, property, query} from 'lit-element';
import { View } from '../../views/view';

@customElement('collaboration-view')
export class CollaborationView extends View {

  private static TOPICS = ['Gaming', 'Frogs', 'Cinnamon'];

  @query('#topic-selector')
  private topicSelector: any;

  @property({type: String})
  private selectedTopic: string = CollaborationView.TOPICS[0];

  render() {
    return html`
      <h1>Feel free to chat in the collaboration view</h1>
      <vaadin-select id="topic-selector" label="Select topic" @change=${this.onTopicChanged}></vaadin-select>
      <collaboration-discussion topic=${this.selectedTopic} style="margin-top: var(--lumo-space-l);">
      </collaboration-discussion>
    `;
  }

  protected firstUpdated() {
    this.topicSelector.renderer = (root: any, select: any) => {
      if (root.firstChild) {
        return;
      }
      const listBox = document.createElement('vaadin-list-box');
      CollaborationView.TOPICS.forEach(topic => {
        const item = document.createElement('vaadin-item');
        item.textContent = topic;
        listBox.appendChild(item);
      });
      root.appendChild(listBox);
      select.value = this.selectedTopic;
    }
  }

  private onTopicChanged(event: any) {
    this.selectedTopic = event.target.value;
  }
}
