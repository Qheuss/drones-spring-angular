import { Component, inject, input, output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IDrone } from '@/models/IDrone';
import { DroneService } from '@/services/drone.service';
import { BatteryService } from '@/services/battery.service';
import { CameraService } from '@/services/camera.service';
import { FlightControllerService } from '@/services/flight-controller.service';
import { FrameService } from '@/services/frame.service';
import { MotorService } from '@/services/motor.service';
import { PropService } from '@/services/prop.service';
import { VideoLinkType } from '@/models/enums/VideoLinkType';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { SelectModule } from 'primeng/select';
import { FormsModule } from '@angular/forms';
import { AsyncPipe } from '@angular/common';

@Component({
    selector: 'app-update-drone',
    standalone: true,
    imports: [CommonModule, DialogModule, ButtonModule, InputGroupModule, InputGroupAddonModule, InputTextModule, InputNumberModule, SelectModule, FormsModule, AsyncPipe],
    templateUrl: './update-drone.html',
    styleUrl: './update-drone.scss'
})
export class UpdateDrone {
    private droneService = inject(DroneService);
    private propService = inject(PropService);
    private motorService = inject(MotorService);
    private flightControllerService = inject(FlightControllerService);
    private cameraService = inject(CameraService);
    private frameService = inject(FrameService);
    private batteryService = inject(BatteryService);

    drone = input<IDrone>();
    droneUpdated = output<void>();

    isDialogVisible = false;
    editingDrone: IDrone | null = null;

    propOptions$ = this.propService.getAll();
    motorOptions$ = this.motorService.getAll();
    flightControllerOptions$ = this.flightControllerService.getAll();
    cameraOptions$ = this.cameraService.getAll();
    frameOptions$ = this.frameService.getAll();
    batteryOptions$ = this.batteryService.getAll();

    videoLinkTypes = Object.values(VideoLinkType);

    openDialog(): void {
        const currentDrone = this.drone();
        if (currentDrone) {
            this.editingDrone = {
                id: currentDrone.id,
                name: currentDrone.name,
                prop: currentDrone.prop,
                motor: currentDrone.motor,
                flightController: currentDrone.flightController,
                camera: currentDrone.camera,
                frame: currentDrone.frame,
                battery: currentDrone.battery,
                videoLinkType: currentDrone.videoLinkType,
                propsCount: currentDrone.propsCount,
                weightGrams: currentDrone.weightGrams,
                wheelbaseMm: currentDrone.wheelbaseMm,
                flightTimeMinutes: currentDrone.flightTimeMinutes,
                isDeleted: currentDrone.isDeleted
            };
            this.isDialogVisible = true;
        }
    }

    closeDialog(): void {
        this.isDialogVisible = false;
        this.editingDrone = null;
    }

    saveDrone(): void {
        const currentDrone = this.drone();
        if (this.editingDrone && currentDrone) {
            this.droneService.updateById(currentDrone.id, this.editingDrone).subscribe({
                next: () => {
                    console.log('Drone updated successfully: ', this.editingDrone);
                    this.closeDialog();
                    this.droneUpdated.emit();
                },
                error: (error) => {
                    console.error('Unable to update drone:', error);
                }
            });
        }
    }
}
