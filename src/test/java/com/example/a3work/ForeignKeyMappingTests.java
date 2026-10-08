package com.example.a3work;

import com.example.a3work.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ForeignKeyMappingTests {

    @Test
    void generatesCompositeForeignKeysWithoutConnectingToDatabase() {
        StringWriter ddl = new StringWriter();
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersModel.class);
        configuration.addAnnotatedClass(CategoriesModel.class);
        configuration.addAnnotatedClass(ProjectsModel.class);
        configuration.addAnnotatedClass(ProjectSubmissionsModel.class);
        configuration.addAnnotatedClass(ProjectParticipantsModel.class);
        configuration.addAnnotatedClass(ProjectReviewModel.class);
        configuration.addAnnotatedClass(ProjectEventsModel.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.boot.allow_jdbc_metadata_access", "false");
        configuration.setProperty("jakarta.persistence.validation.mode", "none");
        configuration.setProperty("jakarta.persistence.schema-generation.database.action", "none");
        configuration.setProperty("jakarta.persistence.schema-generation.scripts.action", "create");
        configuration.getProperties().put("jakarta.persistence.schema-generation.scripts.create-target", ddl);

        // Bootstrapping validates repeated-column mappings and non-PK composite references.
        try (SessionFactory ignored = configuration.buildSessionFactory()) {
            String sql = ddl.toString().toLowerCase(Locale.ROOT).replaceAll("\\s+", " ");
            assertTrue(sql.contains("constraint uq_projects_author unique (id, author_id)"), sql);
            assertTrue(sql.contains("constraint uq_projects_professor unique (id, professor_id)"), sql);
            for (String table : new String[]{"participants", "reviews", "events"}) {
                assertTrue(sql.contains("constraint fk_" + table + "_submission foreign key (project_id, submission_no) "
                        + "references project_submissions (project_id, submission_no) on delete restrict on update restrict"), sql);
            }
            assertTrue(sql.contains("constraint fk_reviews_professor_user foreign key (professor_id) "
                    + "references users (id) on delete restrict on update restrict"), sql);
            assertTrue(sql.contains("constraint fk_events_actor_user foreign key (actor_id) "
                    + "references users (id) on delete restrict on update restrict"), sql);
        }
    }
}
