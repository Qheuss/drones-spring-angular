import { Routes } from '@angular/router';
import { AppLayout } from '@/layout/components/app.layout';

export const appRoutes: Routes = [
    {
        path: '',
        component: AppLayout,
        children: [
            {
                path: '',
                loadComponent: () => import('./app/pages/dashboards/home/home.component').then((c) => c.HomeComponent),
                data: { breadcrumb: 'Accueil' }
            },
            {
                path: 'drones',
                loadComponent: () => import('./app/pages/dashboards/drones/drones.component').then((c) => c.DronesComponent),
                data: { breadcrumb: 'Drones' }
            },
            {
                path: 'batteries',
                loadComponent: () => import('./app/pages/dashboards/batteries/batteries.component').then((c) => c.BatteriesComponent),
                data: { breadcrumb: 'Batteries' }
            },
            {
                path: 'cameras',
                loadComponent: () => import('./app/pages/dashboards/cameras/cameras.component').then((c) => c.CamerasComponent),
                data: { breadcrumb: 'Cameras' }
            },
            {
                path: 'props',
                loadComponent: () => import('./app/pages/dashboards/props/props.component').then((c) => c.PropsComponent),
                data: { breadcrumb: 'Props' }
            },
            {
                path: 'motors',
                loadComponent: () => import('./app/pages/dashboards/motors/motors.component').then((c) => c.MotorsComponent),
                data: { breadcrumb: 'Motors' }
            },
            {
                path: 'frames',
                loadComponent: () => import('./app/pages/dashboards/frames/frames.component').then((c) => c.FramesComponent),
                data: { breadcrumb: 'Frames' }
            },
            {
                path: 'flight-controllers',
                loadComponent: () => import('./app/pages/dashboards/flight-controllers/flight-controllers.component').then((c) => c.FlightControllersComponent),
                data: { breadcrumb: 'Flight Controllers' }
            }
        ]
    },
    { path: '**', redirectTo: '/notfound' }
];
