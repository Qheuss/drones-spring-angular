# MCD

```mermaid
erDiagram
  MOTORS ||--o{ DRONES : "motorise"
  FLIGHT_CONTROLLERS ||--o{ DRONES : "controle"
  CAMERAS ||--o{ DRONES : "capture"
  FRAMES ||--o{ DRONES : "structure"
  BATTERIES ||--o{ DRONES : "alimente"
  PROPS ||--o{ DRONES : "propulse"

    MOTORS {
      BIGINT id PK
      VARCHAR model
      VARCHAR kv_rating
    }

    DRONES {
      BIGINT id PK
      VARCHAR name
      BIGINT flight_controller_id FK
      BIGINT camera_id FK
      BIGINT frame_id FK
      BIGINT battery_id FK
      BIGINT motor_id FK
      BIGINT prop_id FK
      INT props_count "NOT NULL"
      VARCHAR video_link_type "NOT NULL (ENUM)"
      INT weight_grams
      INT wheelbase_mm
      INT flight_time_minutes
    }

    FLIGHT_CONTROLLERS {
      BIGINT id PK
      VARCHAR model
      INT channel_count
      VARCHAR control_link_protocol "NOT NULL (ENUM)"
      VARCHAR control_mode "NOT NULL (ENUM)"
    }

    CAMERAS {
      BIGINT id PK
      VARCHAR model
      INT resolution_mp
    }

    FRAMES {
      BIGINT id PK
      VARCHAR model
      VARCHAR material
    }

    BATTERIES {
      BIGINT id PK
      VARCHAR model
      INT capacity_mah
    }

    PROPS {
      BIGINT id PK
      VARCHAR model
      VARCHAR spec
    }
```

## Cardinalites

- MOTOR 0..N DRONES et DRONE 1..1 MOTOR
- PROP 0..N DRONES et DRONE 1..1 PROP
- FLIGHT_CONTROLLER 0..N DRONES et DRONE 1..1 FLIGHT_CONTROLLER
- CAMERA 0..N DRONES et DRONE 1..1 CAMERA
- FRAME 0..N DRONES et DRONE 1..1 FRAME
- BATTERY 0..N DRONES et DRONE 1..1 BATTERY

## ENUM

- video_link_type: ANALOG, DIGITAL
- control_link_protocol: ELRS, CROSSFIRE, FRSKY, SBUS, IBUS, DSMX
- control_mode: ACRO, ANGLE, HORIZON, SELF_LEVEL, HOVER, RTH
