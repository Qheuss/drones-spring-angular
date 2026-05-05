import { Routes } from '@angular/router';
import { AppLayout } from '@/layout/components/app.layout';

export const appRoutes: Routes = [
    {
        path: '',
        component: AppLayout,
        children: [
            {
                path: '',
                loadComponent: () => import('./app/pages/dashboards/home/home.component').then(c => c.HomeComponent),
                data: { breadcrumb: 'Accueil' },
            },
        ],
    },
    { path: '**', redirectTo: '/notfound' },
];
