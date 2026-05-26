import { IDrone } from '@/models/IDrone';
import { Component, Input, output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';

@Component({
    standalone: true,
    selector: 'app-trash',
    imports: [CommonModule, DialogModule, ButtonModule],
    templateUrl: './trash.html',
    styleUrls: ['./trash.scss']
})
export class Trash {
    isDialogVisible = false;
    @Input()
    deletedDrones: IDrone[] = [];
    droneRestored = output<IDrone>();

    openDialog(): void {
        this.isDialogVisible = true;
    }

    closeDialog(): void {
        this.isDialogVisible = false;
    }

    restoreDrone(drone: IDrone): void {
        this.droneRestored.emit({
            ...drone,
            isDeleted: false
        });
        this.closeDialog();
    }
}
