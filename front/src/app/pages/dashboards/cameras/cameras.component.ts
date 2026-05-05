import { Component, inject } from '@angular/core';
import { TableModule } from 'primeng/table';
import { ICamera } from '@/models/ICamera';
import { CameraService } from '@/services/camera.service';

@Component({
    selector: 'app-cameras',
    imports: [TableModule],
    templateUrl: './cameras.component.html',
    styleUrl: './cameras.component.scss'
})
export class CamerasComponent {
    private cameraService = inject(CameraService);

    cameras: ICamera[] = [];

    ngOnInit(): void {
        this.cameraService.getAll().subscribe((data) => {
            this.cameras = data;
        });
    }
}
