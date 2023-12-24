
CREATE TABLE access_log
(
  id         INTEGER       NOT NULL,
  user_id    VARCHAR(255)  NOT NULL,
  state      VARCHAR(255)  NOT NULL,
  params     VARCHAR(1024) NULL    ,
  created_at TIME          NULL    ,
  PRIMARY KEY (id)
) COMMENT 'ON';

CREATE TABLE actor
(
  id              BIGINT        NOT NULL DEFAULT AS,
  name            VARCHAR(255)  NOT NULL,
  description     VARCHAR(4000) NOT NULL,
  last_updated_at TIME          NULL     DEFAULT NOW,
  last_updated_by VARCHAR(255)  NOT NULL,
  is_external     BOOLEAN       NOT NULL DEFAULT FALSE,
  provenance      VARCHAR(64)   NOT NULL DEFAULT waltz,
  external_id     VARCHAR(200)  NULL    ,
  PRIMARY KEY (id)
) COMMENT 'ON';

ALTER TABLE actor
  ADD CONSTRAINT UQ_name UNIQUE (name);

ALTER TABLE actor
  ADD CONSTRAINT UQ_external_id UNIQUE (external_id);

CREATE TABLE application
(
  id                      BIGINT        NOT NULL DEFAULT AS,
  name                    VARCHAR(255)  NULL    ,
  description             VARCHAR(4000) NULL    ,
  asset_code              VARCHAR(255)  NULL    ,
  created_at              TIME          NOT NULL DEFAULT NOW,
  updated_at              TIME          NOT NULL,
  organisational_unit_id  BIGINT        NOT NULL,
  kind                    VARCHAR(128)  NOT NULL DEFAULT IN_HOUSE,
  lifecycle_phase         VARCHAR(128)  NOT NULL DEFAULT PRODUCTION,
  parent_asset_code       VARCHAR(255)  NULL    ,
  overall_rating          CHAR(1)       NOT NULL DEFAULT Z,
  provenance              VARCHAR(64)   NOT NULL DEFAULT waltz,
  business_criticality    VARCHAR(128)  NOT NULL DEFAULT UNKNOWN,
  is_removed              BOOLEAN       NOT NULL DEFAULT FALSE,
  entity_lifecycle_status VARCHAR(64)   NOT NULL DEFAULT ACTIVE,
  planned_retirement_date TIME          NULL    ,
  actual_retirement_date  TIME          NULL    ,
  commission_date         TIME          NULL    ,
  PRIMARY KEY (id)
) COMMENT 'ON';

CREATE TABLE application_component
(
  id             BIGINT NOT NULL,
  application_id BIGINT NULL    ,
  PRIMARY KEY (id)
);

CREATE TABLE application_group
(
  id                 BIGINT       NOT NULL DEFAULT AS,
  name               VARCHAR(255) NOT NULL,
  kind               VARCHAR(64)  NOT NULL DEFAULT PUBLIC,
  description        TEXT         NULL    ,
  external_id        VARCHAR(200) NULL    ,
  is_removed         BOOLEAN      NOT NULL DEFAULT FALSE,
  is_favourite_group BOOLEAN      NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id)
) COMMENT 'ON';

CREATE TABLE application_group_entry
(
  group_id       BIGINT      NOT NULL,
  application_id BIGINT      NOT NULL,
  is_readonly    BOOLEAN     NOT NULL DEFAULT FALSE,
  provenance     VARCHAR(64) NOT NULL,
  created_at     TIME        NOT NULL,
  PRIMARY KEY (group_id, application_id)
) COMMENT 'ON';

CREATE TABLE application_group_member
(
  group_id BIGINT       NOT NULL,
  user_id  VARCHAR(128) NOT NULL,
  role     VARCHAR(64)  NOT NULL DEFAULT VIEWER,
  PRIMARY KEY (group_id, user_id)
) COMMENT 'ON';

CREATE TABLE application_group_ou_entry
(
  group_id    BIGINT      NOT NULL,
  org_unit_id BIGINT      NOT NULL,
  is_readonly BOOLEAN     NOT NULL DEFAULT FALSE,
  provenance  VARCHAR(64) NOT NULL DEFAULT waltz,
  created_at  TIME        NOT NULL DEFAULT NOW,
  PRIMARY KEY (group_id, org_unit_id)
) COMMENT 'ON';

CREATE TABLE application_relationship
(
  id            BIGINT NOT NULL,
  relation_kind BIGINT NULL    ,
  PRIMARY KEY (id)
);

CREATE TABLE complexity
(
  id                 BIGINT        NOT NULL DEFAULT AS,
  complexity_kind_id BIGINT        NOT NULL,
  entity_id          BIGINT        NOT NULL,
  entity_kind        VARCHAR(64)   NOT NULL,
  score              numeric(10,3) NOT NULL,
  last_updated_at    TIME          NOT NULL DEFAULT NOW,
  last_updated_by    VARCHAR(255)  NOT NULL,
  provenance         VARCHAR(64)   NOT NULL DEFAULT waltz,
  PRIMARY KEY (id)
) COMMENT 'ON';

CREATE TABLE complexity_kind
(
  id          BIGINT        NOT NULL DEFAULT AS,
  name        VARCHAR(255)  NOT NULL,
  description VARCHAR(4000) NULL    ,
  external_id VARCHAR(200)  NULL    ,
  is_default  BOOLEAN       NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id)
) COMMENT 'ON';

CREATE TABLE custom_environment
(
  id                 BIGINT        NOT NULL DEFAULT AS,
  owning_entity_id   BIGINT        NOT NULL,
  owning_entity_kind VARCHAR(64)   NOT NULL,
  name               VARCHAR(255)  NOT NULL,
  description        VARCHAR(4000) NULL    ,
  external_id        VARCHAR(200)  NOT NULL,
  group_name         VARCHAR(255)  NOT NULL DEFAULT Default,
  PRIMARY KEY (id)
);

CREATE TABLE custom_environment_usage
(
  id                    BIGINT       NOT NULL DEFAULT AS,
  custom_environment_id BIGINT       NOT NULL,
  entity_id             BIGINT       NOT NULL,
  entity_kind           VARCHAR(64)  NOT NULL,
  created_at            TIME         NOT NULL DEFAULT NOW,
  created_by            VARCHAR(255) NOT NULL,
  provenance            VARCHAR(64)  NOT NULL DEFAULT waltz,
  PRIMARY KEY (id)
);

CREATE TABLE database_information
(
  id               BIGINT       NOT NULL DEFAULT AS,
  database_name    VARCHAR(255) NOT NULL DEFAULT waltz,
  instance_name    VARCHAR(255) NOT NULL DEFAULT waltz,
  dbms_vendor      VARCHAR(255) NOT NULL,
  dbms_name        VARCHAR(255) NOT NULL,
  dbms_version     VARCHAR(128) NOT NULL,
  external_id      VARCHAR(200) NULL     DEFAULT waltz,
  end_of_life_date date         NULL    ,
  lifecycle_status VARCHAR(64)  NULL    ,
  provenance       VARCHAR(64)  NOT NULL DEFAULT waltz,
  PRIMARY KEY (id)
);

CREATE TABLE database_usage
(
  id              BIGINT       NOT NULL DEFAULT AS,
  database_id     BIGINT       NOT NULL,
  entity_kind     VARCHAR(64)  NOT NULL,
  entity_id       BIGINT       NOT NULL,
  environment     VARCHAR(64)  NOT NULL,
  last_updated_at TIME         NOT NULL DEFAULT NOW,
  last_updated_by VARCHAR(255) NOT NULL,
  provenance      VARCHAR(64)  NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE database_usage
  ADD CONSTRAINT UQ_environment UNIQUE (environment);

CREATE TABLE involvement
(
  entity_kind VARCHAR(128) NOT NULL,
  entity_id   BIGINT       NOT NULL,
  employee_id VARCHAR(128) NOT NULL,
  provenance  VARCHAR(64)  NOT NULL DEFAULT waltz,
  kind_id     BIGINT       NOT NULL,
  is_readonly BOOLEAN      NOT NULL DEFAULT TRUE
) COMMENT 'ON';

CREATE TABLE involvement_group
(
  id          BIGINT       NOT NULL DEFAULT AS,
  name        VARCHAR(255) NOT NULL,
  external_id VARCHAR(200) NOT NULL,
  provenance  VARCHAR(64)  NOT NULL,
  PRIMARY KEY (id)
) COMMENT 'ON';

ALTER TABLE involvement_group
  ADD CONSTRAINT UQ_external_id UNIQUE (external_id);

CREATE TABLE involvement_group_entry
(
  involvement_group_id BIGINT NOT NULL,
  involvement_kind_id  BIGINT NOT NULL
) COMMENT 'ON';

CREATE TABLE involvement_kind
(
  id              BIGINT        NOT NULL DEFAULT AS,
  description     VARCHAR(4000) NOT NULL,
  last_updated_at TIME          NULL     DEFAULT NOW,
  last_updated_by VARCHAR(255)  NOT NULL,
  external_id     VARCHAR(200)  NULL    ,
  user_selectable BOOLEAN       NOT NULL DEFAULT TRUE,
  subject_kind    VARCHAR(64)   NOT NULL,
  name            VARCHAR(255)  NOT NULL,
  permitted_role  VARCHAR(255)  NULL    ,
  PRIMARY KEY (id)
) COMMENT 'ON';

ALTER TABLE involvement_kind
  ADD CONSTRAINT UQ_subject_kind UNIQUE (subject_kind);

ALTER TABLE involvement_kind
  ADD CONSTRAINT UQ_name UNIQUE (name);

CREATE TABLE key_involvement_kind
(
  involvement_kind_id BIGINT      NOT NULL,
  entity_kind         VARCHAR(64) NOT NULL
) COMMENT 'ON';

ALTER TABLE key_involvement_kind
  ADD CONSTRAINT UQ_involvement_kind_id UNIQUE (involvement_kind_id);

ALTER TABLE key_involvement_kind
  ADD CONSTRAINT UQ_entity_kind UNIQUE (entity_kind);

CREATE TABLE organisational_unit
(
  id              BIGINT        NOT NULL,
  name            VARCHAR(255)  NULL    ,
  description     VARCHAR(4000) NULL    ,
  parent_id       BIGINT        NULL    ,
  created_at      TIME          NOT NULL DEFAULT NOW,
  last_updated_at TIME          NOT NULL,
  external_id     VARCHAR(200)  NULL    ,
  created_by      VARCHAR(255)  NOT NULL DEFAULT waltz,
  last_updated_by VARCHAR(255)  NOT NULL DEFAULT waltz,
  provenance      VARCHAR(64)   NOT NULL DEFAULT waltz,
  PRIMARY KEY (id)
);

CREATE TABLE permission_group
(
  id          BIGINT        NOT NULL DEFAULT AS,
  name        VARCHAR(255)  NOT NULL,
  external_id VARCHAR(200)  NOT NULL,
  description VARCHAR(4000) NULL    ,
  provenance  VARCHAR(64)   NOT NULL,
  is_default  BOOLEAN       NOT NULL DEFAULT TRUE,
  PRIMARY KEY (id)
) COMMENT 'ON';

ALTER TABLE permission_group
  ADD CONSTRAINT UQ_external_id UNIQUE (external_id);

CREATE TABLE permission_group_entry
(
  entity_id           BIGINT      NOT NULL,
  permission_group_id BIGINT      NOT NULL,
  entity_kind         VARCHAR(64) NOT NULL
) COMMENT 'ON';

CREATE TABLE permission_group_involvement
(
  permission_group_id  BIGINT      NOT NULL,
  involvement_group_id BIGINT      NULL    ,
  operation            VARCHAR(64) NOT NULL,
  parent_kind          VARCHAR(64) NOT NULL,
  subject_kind         VARCHAR(64) NULL    ,
  qualifier_kind       VARCHAR(64) NULL    ,
  qualifier_id         BIGINT      NULL    
) COMMENT 'ON';

CREATE TABLE person
(
  id                     BIGINT       NOT NULL DEFAULT AS,
  employee_id            VARCHAR(128) NULL    ,
  display_name           VARCHAR(255) NOT NULL,
  email                  VARCHAR(255) NOT NULL,
  user_principal_name    VARCHAR(255) NULL    ,
  department_name        VARCHAR(255) NULL    ,
  kind                   VARCHAR(255) NOT NULL,
  manager_employee_id    VARCHAR(128) NULL    ,
  title                  VARCHAR(255) NULL    ,
  office_phone           VARCHAR(128) NULL    ,
  mobile_phone           VARCHAR(128) NULL    ,
  organisational_unit_id BIGINT       NULL    ,
  is_removed             BOOLEAN      NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id)
);

ALTER TABLE person
  ADD CONSTRAINT UQ_employee_id UNIQUE (employee_id);

ALTER TABLE person
  ADD CONSTRAINT UQ_organisational_unit_id UNIQUE (organisational_unit_id);

CREATE TABLE person_hierarchy
(
  manager_id  VARCHAR(128) NOT NULL,
  employee_id VARCHAR(128) NOT NULL,
  level       INTEGER      NOT NULL,
  PRIMARY KEY (manager_id, employee_id)
);

CREATE TABLE relationship_kind
(
  id           BIGINT        NOT NULL DEFAULT AS,
  name         VARCHAR(255)  NOT NULL,
  description  VARCHAR(4000) NULL    ,
  kind_a       VARCHAR(128)  NOT NULL,
  kind_b       VARCHAR(128)  NOT NULL,
  category_a   BIGINT        NULL    ,
  category_b   BIGINT        NULL    ,
  is_readonly  BOOLEAN       NOT NULL DEFAULT FALSE,
  code         VARCHAR(128)  NOT NULL,
  position     INTEGER       NOT NULL DEFAULT 0,
  reverse_name VARCHAR(255)  NOT NULL,
  PRIMARY KEY (id)
) COMMENT 'ON';

ALTER TABLE relationship_kind
  ADD CONSTRAINT UQ_kind_a UNIQUE (kind_a);

ALTER TABLE relationship_kind
  ADD CONSTRAINT UQ_kind_b UNIQUE (kind_b);

ALTER TABLE relationship_kind
  ADD CONSTRAINT UQ_code UNIQUE (code);

CREATE TABLE role
(
  NOT                           NULL    ,
  is_custom       BOOLEAN       NOT NULL DEFAULT TRUE,
  name            VARCHAR(255)  NOT NULL,
  description     VARCHAR(4000) NOT NULL,
  user_selectable BOOLEAN       NOT NULL DEFAULT TRUE
);

CREATE TABLE server_information
(
  id                       BIGINT       NOT NULL DEFAULT AS,
  hostname                 VARCHAR(255) NOT NULL,
  operating_system         VARCHAR(128) NOT NULL DEFAULT UNKNOWN,
  location                 VARCHAR(128) NOT NULL,
  operating_system_version VARCHAR(128) NOT NULL,
  country                  VARCHAR(128) NOT NULL,
  is_virtual               BOOLEAN      NULL    ,
  provenance               VARCHAR(64)  NOT NULL DEFAULT waltz,
  os_end_of_life_date      date         NULL    ,
  hw_end_of_life_date      date         NULL    ,
  lifecycle_status         VARCHAR(64)  NOT NULL DEFAULT UNKNOWN,
  external_id              VARCHAR(200) NULL    ,
  PRIMARY KEY (id)
);

CREATE TABLE server_usage
(
  server_id       BIGINT       NOT NULL,
  entity_kind     VARCHAR(64)  NOT NULL,
  entity_id       BIGINT       NOT NULL,
  environment     VARCHAR(64)  NOT NULL DEFAULT UNKNOWN,
  last_updated_at TIME         NOT NULL DEFAULT NOW,
  last_updated_by VARCHAR(255) NOT NULL,
  provenance      VARCHAR(64)  NOT NULL,
  id              BIGINT       NOT NULL DEFAULT AS,
  PRIMARY KEY (id)
);

ALTER TABLE server_usage
  ADD CONSTRAINT UQ_environment UNIQUE (environment);

CREATE TABLE settings
(
  name        VARCHAR(128)  NOT NULL,
  value       VARCHAR(4000) NULL    ,
  restricted  BOOLEAN       NOT NULL DEFAULT FALSE,
  description VARCHAR(4000) NULL    ,
  PRIMARY KEY (name)
) COMMENT 'ON';

CREATE TABLE thumbnail
(
  parent_entity_kind VARCHAR(64)  NOT NULL,
  parent_entity_id   BIGINT       NOT NULL,
  last_updated_at    TIME         NOT NULL DEFAULT NOW,
  last_updated_by    VARCHAR(255) NOT NULL,
  mime_type          VARCHAR(255) NOT NULL,
  blob               BYTEA        NOT NULL,
  external_id        VARCHAR(200) NULL    ,
  provenance         VARCHAR(64)  NOT NULL,
  PRIMARY KEY (parent_entity_kind, parent_entity_id)
);

CREATE TABLE user
(
  user_name VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_name)
);

CREATE TABLE user_agent_info
(
  id               INTEGER      NOT NULL DEFAULT AS,
  user_name        VARCHAR(128) NOT NULL,
  user_agent       VARCHAR(500) NOT NULL,
  resolution       VARCHAR(128) NOT NULL,
  operating_system VARCHAR(128) NOT NULL,
  ip_address       VARCHAR(128) NOT NULL,
  login_timestamp  TIME         NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_preference
(
  NOT                     NULL    ,
  value     VARCHAR(2048) NOT NULL,
  user_name VARCHAR(255)  NOT NULL,
  PRIMARY KEY (user_name)
);

CREATE TABLE user_role
(
  user_name VARCHAR(255) NOT NULL,
  role      VARCHAR(255) NOT NULL
);

ALTER TABLE organisational_unit
  ADD CONSTRAINT FK_person_TO_organisational_unit
    FOREIGN KEY (id)
    REFERENCES person (organisational_unit_id);

ALTER TABLE application_group_member
  ADD CONSTRAINT FK_application_group_TO_application_group_member
    FOREIGN KEY (group_id)
    REFERENCES application_group (id);

ALTER TABLE involvement
  ADD CONSTRAINT FK_involvement_kind_TO_involvement
    FOREIGN KEY (kind_id)
    REFERENCES involvement_kind (id);

ALTER TABLE involvement
  ADD CONSTRAINT FK_person_TO_involvement
    FOREIGN KEY (employee_id)
    REFERENCES person (employee_id);

ALTER TABLE server_usage
  ADD CONSTRAINT FK_server_information_TO_server_usage
    FOREIGN KEY (server_id)
    REFERENCES server_information (id);

ALTER TABLE application_group_entry
  ADD CONSTRAINT FK_application_group_TO_application_group_entry
    FOREIGN KEY (group_id)
    REFERENCES application_group (id);

ALTER TABLE application_group_entry
  ADD CONSTRAINT FK_application_TO_application_group_entry
    FOREIGN KEY (application_id)
    REFERENCES application (id);

ALTER TABLE application_group_ou_entry
  ADD CONSTRAINT FK_application_group_TO_application_group_ou_entry
    FOREIGN KEY (group_id)
    REFERENCES application_group (id);

ALTER TABLE application_group_ou_entry
  ADD CONSTRAINT FK_organisational_unit_TO_application_group_ou_entry
    FOREIGN KEY (org_unit_id)
    REFERENCES organisational_unit (id);

ALTER TABLE complexity
  ADD CONSTRAINT FK_complexity_kind_TO_complexity
    FOREIGN KEY (complexity_kind_id)
    REFERENCES complexity_kind (id);

ALTER TABLE database_usage
  ADD CONSTRAINT FK_database_information_TO_database_usage
    FOREIGN KEY (database_id)
    REFERENCES database_information (id);

ALTER TABLE permission_group_involvement
  ADD CONSTRAINT FK_permission_group_TO_permission_group_involvement
    FOREIGN KEY (permission_group_id)
    REFERENCES permission_group (id);

ALTER TABLE permission_group_involvement
  ADD CONSTRAINT FK_involvement_group_TO_permission_group_involvement
    FOREIGN KEY (involvement_group_id)
    REFERENCES involvement_group (id);

ALTER TABLE custom_environment_usage
  ADD CONSTRAINT FK_custom_environment_TO_custom_environment_usage
    FOREIGN KEY (custom_environment_id)
    REFERENCES custom_environment (id);

ALTER TABLE key_involvement_kind
  ADD CONSTRAINT FK_involvement_kind_TO_key_involvement_kind
    FOREIGN KEY (involvement_kind_id)
    REFERENCES involvement_kind (id);

ALTER TABLE application_component
  ADD CONSTRAINT FK_application_TO_application_component
    FOREIGN KEY (application_id)
    REFERENCES application (id);

ALTER TABLE involvement_group_entry
  ADD CONSTRAINT FK_involvement_group_TO_involvement_group_entry
    FOREIGN KEY (involvement_group_id)
    REFERENCES involvement_group (id);

ALTER TABLE involvement_group_entry
  ADD CONSTRAINT FK_involvement_kind_TO_involvement_group_entry
    FOREIGN KEY (involvement_kind_id)
    REFERENCES involvement_kind (id);

ALTER TABLE permission_group_entry
  ADD CONSTRAINT FK_permission_group_TO_permission_group_entry
    FOREIGN KEY (permission_group_id)
    REFERENCES permission_group (id);

ALTER TABLE user_agent_info
  ADD CONSTRAINT FK_user_TO_user_agent_info
    FOREIGN KEY (user_name)
    REFERENCES user (user_name);

ALTER TABLE user_preference
  ADD CONSTRAINT FK_user_TO_user_preference
    FOREIGN KEY (user_name)
    REFERENCES user (user_name);

ALTER TABLE user_role
  ADD CONSTRAINT FK_role_TO_user_role
    FOREIGN KEY (role)
    REFERENCES role ();

ALTER TABLE user_role
  ADD CONSTRAINT FK_user_TO_user_role
    FOREIGN KEY (user_name)
    REFERENCES user (user_name);

CREATE INDEX idx_asset_code
  ON application (asset_code ASC);

CREATE INDEX idx_organisational_unit_id
  ON application (organisational_unit_id ASC);

CREATE INDEX idx_els_application
  ON application (entity_lifecycle_status ASC);

CREATE UNIQUE INDEX idx_si_hostname
  ON server_information (hostname ASC);

CREATE UNIQUE INDEX idx_si_external_id
  ON server_information (external_id ASC);

CREATE INDEX idx_involvement_entity_emp
  ON involvement (entity_kind ASC, entity_id ASC, employee_id ASC);

CREATE UNIQUE INDEX idx_inv_kind_ext_id_uniq
  ON involvement_kind (external_id ASC);

CREATE INDEX idx_person_email
  ON person (email ASC);

CREATE UNIQUE INDEX idx_su_s_id_id_kind_env
  ON server_usage (server_id ASC, entity_id ASC, entity_kind ASC, environment ASC);

CREATE UNIQUE INDEX idx_owning_entity_name
  ON custom_environment (name ASC, owning_entity_kind ASC, owning_entity_id ASC);

CREATE UNIQUE INDEX idx_env_id_entity
  ON custom_environment_usage (custom_environment_id ASC, entity_kind ASC, entity_id ASC);
