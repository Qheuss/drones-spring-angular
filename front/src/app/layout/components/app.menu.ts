import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppMenuitem } from './app.menuitem';

@Component({
    selector: 'app-menu',
    standalone: true,
    imports: [CommonModule, AppMenuitem, RouterModule],
    template: `<ul class="layout-menu">
        <ng-container *ngFor="let item of model; let i = index">
            <li app-menuitem *ngIf="!item.separator" [item]="item" [index]="i" [root]="true"></li>
            <li *ngIf="item.separator" class="menu-separator"></li>
        </ng-container>
    </ul> `
})
export class AppMenu {
    model: any[] = [];

    ngOnInit() {
        this.model = [
            {
                label: 'Menu',
                icon: 'pi pi-home',
                items: [
                    {
                        label: 'Accueil',
                        icon: 'pi pi-fw pi-home',
                        routerLink: ['/']
                    },
                    {
                        label: 'Drones',
                        icon: 'pi pi-fw pi-desktop',
                        routerLink: ['/drones']
                    },
                    {
                        label: 'Batteries',
                        icon: 'pi pi-fw pi-bolt',
                        routerLink: ['/batteries']
                    },
                    {
                        label: 'Cameras',
                        icon: 'pi pi-fw pi-camera',
                        routerLink: ['/cameras']
                    },
                    {
                        label: 'Props',
                        icon: 'pi pi-fw pi-cog',
                        routerLink: ['/props']
                    },
                    {
                        label: 'Motors',
                        icon: 'pi pi-fw pi-wrench',
                        routerLink: ['/motors']
                    },
                    {
                        label: 'Frames',
                        icon: 'pi pi-fw pi-box',
                        routerLink: ['/frames']
                    },
                    {
                        label: 'Flight Controllers',
                        icon: 'pi pi-fw pi-sitemap',
                        routerLink: ['/flight-controllers']
                    }
                ]
            }
        ];
    }
}
