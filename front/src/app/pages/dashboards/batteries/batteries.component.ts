import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { IBattery } from '@/models/IBattery';
import { BatteryService } from '@/services/battery.service';

@Component({
    selector: 'app-batteries',
    imports: [TableModule],
    templateUrl: './batteries.component.html',
    styleUrl: './batteries.component.scss'
})
export class BatteriesComponent {
    private batteryService = inject(BatteryService);

    batteries: IBattery[] = [];

    ngOnInit(): void {
        this.batteryService.getAll().subscribe((data) => {
            this.batteries = data;
        });
    }
}
