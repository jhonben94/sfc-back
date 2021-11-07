
CREATE SEQUENCE public.vencimiento_puntos_vencimiento_punto_seq;

CREATE TABLE public.vencimiento_puntos (
                vencimiento_punto INTEGER NOT NULL DEFAULT nextval('public.vencimiento_puntos_vencimiento_punto_seq'),
                fecha_inicio_validez DATE NOT NULL,
                fecha_fin_validez DATE NOT NULL,
                dias_validez INTEGER NOT NULL,
                CONSTRAINT vencimiento_puntos_pk PRIMARY KEY (vencimiento_punto)
);


ALTER SEQUENCE public.vencimiento_puntos_vencimiento_punto_seq OWNED BY public.vencimiento_puntos.vencimiento_punto;

CREATE SEQUENCE public.asignacion_puntos_asignacion_punto_seq;

CREATE TABLE public.asignacion_puntos (
                asignacion_punto INTEGER NOT NULL DEFAULT nextval('public.asignacion_puntos_asignacion_punto_seq'),
                limite_inferior INTEGER NOT NULL,
                limite_superior INTEGER NOT NULL,
                monto_equivalencia INTEGER NOT NULL,
                CONSTRAINT asignacion_puntos_pk PRIMARY KEY (asignacion_punto)
);


ALTER SEQUENCE public.asignacion_puntos_asignacion_punto_seq OWNED BY public.asignacion_puntos.asignacion_punto;

CREATE SEQUENCE public.concepto_puntos_uso_punto_seq;

CREATE TABLE public.concepto_puntos (
                concepto_punto INTEGER NOT NULL DEFAULT nextval('public.concepto_puntos_uso_punto_seq'),
                descripcion_concepto VARCHAR NOT NULL,
                puntos_requeridos INTEGER NOT NULL,
                CONSTRAINT concepto_puntos_pk PRIMARY KEY (concepto_punto)
);


ALTER SEQUENCE public.concepto_puntos_uso_punto_seq OWNED BY public.concepto_puntos.concepto_punto;

CREATE SEQUENCE public.clientes_cliente_seq;

CREATE TABLE public.clientes (
                cliente INTEGER NOT NULL DEFAULT nextval('public.clientes_cliente_seq'),
                nombre VARCHAR(60) NOT NULL,
                documento VARCHAR(60) NOT NULL,
                apellido VARCHAR(60) NOT NULL,
                tipo_documento VARCHAR(10) NOT NULL,
                correo VARCHAR(60) NOT NULL,
                nacionalidad VARCHAR(10) NOT NULL,
                telefono VARCHAR(20) NOT NULL,
                CONSTRAINT clientes_pk PRIMARY KEY (cliente)
);


ALTER SEQUENCE public.clientes_cliente_seq OWNED BY public.clientes.cliente;

CREATE TABLE public.uso_puntos (
                uso_punto INTEGER NOT NULL,
                cliente INTEGER NOT NULL,
                puntaje_utilizado INTEGER NOT NULL,
                concepto_punto INTEGER NOT NULL,
                CONSTRAINT uso_puntos_pk PRIMARY KEY (uso_punto)
);


CREATE SEQUENCE public.bolsa_puntos_bolsa_punto_seq;

CREATE TABLE public.bolsa_puntos (
                bolsa_punto INTEGER NOT NULL DEFAULT nextval('public.bolsa_puntos_bolsa_punto_seq'),
                cliente INTEGER NOT NULL,
                fecha_asignacion_puntos DATE NOT NULL,
                fecha_vencimiento_puntos DATE NOT NULL,
                monto_operacion INTEGER NOT NULL,
                saldo_puntos INTEGER NOT NULL,
                puntaje_utilizado INTEGER NOT NULL,
                CONSTRAINT bolsa_puntos_pk PRIMARY KEY (bolsa_punto)
);


ALTER SEQUENCE public.bolsa_puntos_bolsa_punto_seq OWNED BY public.bolsa_puntos.bolsa_punto;

CREATE SEQUENCE public.uso_puntos_detalle_uso_punto_detalle_seq;

CREATE TABLE public.uso_puntos_detalle (
                uso_punto_detalle INTEGER NOT NULL DEFAULT nextval('public.uso_puntos_detalle_uso_punto_detalle_seq'),
                uso_punto INTEGER NOT NULL,
                puntaje_utilizado INTEGER NOT NULL,
                bolsa_punto INTEGER NOT NULL,
                CONSTRAINT uso_puntos_detalle_pk PRIMARY KEY (uso_punto_detalle)
);


ALTER SEQUENCE public.uso_puntos_detalle_uso_punto_detalle_seq OWNED BY public.uso_puntos_detalle.uso_punto_detalle;

ALTER TABLE public.uso_puntos ADD CONSTRAINT concepto_puntos_uso_puntos_fk
FOREIGN KEY (concepto_punto)
REFERENCES public.concepto_puntos (concepto_punto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.bolsa_puntos ADD CONSTRAINT clientes_bolsa_puntos_fk
FOREIGN KEY (cliente)
REFERENCES public.clientes (cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.uso_puntos ADD CONSTRAINT clientes_uso_puntos_fk
FOREIGN KEY (cliente)
REFERENCES public.clientes (cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.uso_puntos_detalle ADD CONSTRAINT uso_puntos_uso_puntos_detalle_fk
FOREIGN KEY (uso_punto)
REFERENCES public.uso_puntos (uso_punto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.uso_puntos_detalle ADD CONSTRAINT bolsa_puntos_uso_puntos_detalle_fk
FOREIGN KEY (bolsa_punto)
REFERENCES public.bolsa_puntos (bolsa_punto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;