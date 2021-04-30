import { Route } from '@vaadin/router';
import './views/collaboration/collaboration-view';
import './views/main/main-view';

export type ViewRoute = Route & { title?: string; children?: ViewRoute[] };

export const views: ViewRoute[] = [
  // for client-side, place routes below (more info https://vaadin.com/docs/v19/flow/typescript/creating-routes.html)
  {
    path: '',
    component: 'collaboration-view',
    title: '',
  }
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-view',
    children: [...views],
  },
];
