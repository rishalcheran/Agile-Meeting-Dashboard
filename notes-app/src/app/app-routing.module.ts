import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNotesComponent } from './components/add-notes/add-notes.component';
import { ViewNotesComponent } from './components/view-notes/view-notes.component';
import { ViewActionsComponent } from './components/view-actions/view-actions.component';

const routes: Routes = [
  { path: '', component: AddNotesComponent, pathMatch: 'full' },
  { path: 'add-notes', component: AddNotesComponent, pathMatch: 'full' },
  { path: 'view-notes', component: ViewNotesComponent, pathMatch: 'full' },
  { path: 'view-actions', component: ViewActionsComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
