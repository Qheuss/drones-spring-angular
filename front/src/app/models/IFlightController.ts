import { ControlLinkProtocol } from './enums/ControlLinkProtocol';
import { FlightControlMode } from './enums/FlightControlMode';

export interface IFlightController {
    id: number;
    model: string;
    channelCount: number;
    controlLinkProtocol: ControlLinkProtocol;
    controlMode: FlightControlMode;
}
