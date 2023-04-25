CREATE TABLE company (
    id bigserial not null constraint user_pkey primary key,
    name varchar,
    creation_date timestamp without time zone,
    creation_date_tz timestamptz
);