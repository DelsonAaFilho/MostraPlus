CREATE TABLE categories
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY,
    code       VARCHAR(32) NOT NULL,
    name       VARCHAR(60) NOT NULL,
    sort_order SMALLINT    NOT NULL,

    CONSTRAINT pk_categories PRIMARY KEY (id),
    CONSTRAINT uq_categories_code UNIQUE (code),
    CONSTRAINT uq_categories_name UNIQUE (name),
    CONSTRAINT uq_categories_sort_order UNIQUE (sort_order),
    CONSTRAINT ck_categories_sort_order_positive CHECK (sort_order > 0)
);

