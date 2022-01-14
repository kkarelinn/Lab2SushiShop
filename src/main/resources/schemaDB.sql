
-- SCHEMA: public

-- DROP SCHEMA IF EXISTS public ;

CREATE SCHEMA IF NOT EXISTS public
    AUTHORIZATION postgres;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT ALL ON SCHEMA public TO PUBLIC;

GRANT ALL ON SCHEMA public TO postgres;

------------------------------------------------------------------------

-- Table: public.category

--DROP TABLE IF EXISTS public.category;

CREATE TABLE IF NOT EXISTS public.category
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default",
    date character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.category
    OWNER to postgres;

----------------

--DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    fullname character varying COLLATE pg_catalog."default" NOT NULL,
    manager integer,
    access_role character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'DEFAULT'::character varying,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;




----------------------------



--DROP TABLE IF EXISTS public.clients;

CREATE TABLE IF NOT EXISTS public.clients
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    fullname character varying COLLATE pg_catalog."default" NOT NULL,
    address character varying COLLATE pg_catalog."default",
    CONSTRAINT clients_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;
---------------------------------

-- Table: public.products

--DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default",
    date character varying COLLATE pg_catalog."default" NOT NULL,
    price_usd numeric,
    category_id integer NOT NULL DEFAULT 1,
    linkprod_id integer,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT category FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;


-------------------------------------------------------------------------------------------------------
-- Table: public.carts

--DROP TABLE IF EXISTS public.carts;

CREATE TABLE IF NOT EXISTS public.carts
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    client_id integer NOT NULL,
    totalprice_uah numeric DEFAULT 0.00,
    date character varying COLLATE pg_catalog."default" NOT NULL,
    deliveryaddress character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    CONSTRAINT carts_pkey PRIMARY KEY (id),
    CONSTRAINT client_id FOREIGN KEY (client_id)
        REFERENCES public.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "userID" FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.carts
    OWNER to postgres;
----------------------------------------------------------------------------------------

-- Table: public.orders

-- DROP TABLE IF EXISTS public.orders;

CREATE TABLE IF NOT EXISTS public.orders
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    product_id integer NOT NULL,
    cart_id integer NOT NULL,
    total_price_uah numeric NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT "cart-fk" FOREIGN KEY (cart_id)
        REFERENCES public.carts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "product-fk" FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE SET NULL
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders
    OWNER to postgres;





