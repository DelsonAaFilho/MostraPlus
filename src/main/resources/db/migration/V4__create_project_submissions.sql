CREATE TABLE project_submissions
(
    project_id                  BIGINT                         NOT NULL,
    submission_no               INTEGER                        NOT NULL,
    category_id                 BIGINT                         NOT NULL,
    title                       VARCHAR(255)                   NOT NULL,
    description                 VARCHAR(255)                   NOT NULL,
    image_url                   VARCHAR(255)                   NOT NULL,
    web_url                     VARCHAR(255)                   NOT NULL,
    contact_email               VARCHAR(255)                   NOT NULL,
    linkedin_url                VARCHAR(255),
    github_url                  VARCHAR(255)                   NOT NULL,
    publication_notice_version  INTEGER                        NOT NULL,
    publication_notice_text     VARCHAR(255)                   NOT NULL,
    publication_acknowledged_at TIMESTAMP(6) WITH TIME ZONE    NOT NULL,
    created_at                  TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_project_submissions PRIMARY KEY (project_id, submission_no),
    CONSTRAINT fk_submissions_project
        FOREIGN KEY (project_id) REFERENCES projects (id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_submissions_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
);

ALTER TABLE projects
    ADD CONSTRAINT fk_projects_current_submission
        FOREIGN KEY (id, current_submission_no)
            REFERENCES project_submissions (project_id, submission_no)
            ON DELETE NO ACTION ON UPDATE RESTRICT
            DEFERRABLE INITIALLY DEFERRED;
