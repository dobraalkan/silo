/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database;


import com.silo.backend.database.tables.AccessLog;
import com.silo.backend.database.tables.Actor;
import com.silo.backend.database.tables.Application;
import com.silo.backend.database.tables.ApplicationComponent;
import com.silo.backend.database.tables.ApplicationGroup;
import com.silo.backend.database.tables.ApplicationGroupEntry;
import com.silo.backend.database.tables.ApplicationGroupMember;
import com.silo.backend.database.tables.ApplicationGroupOuEntry;
import com.silo.backend.database.tables.ApplicationRelationship;
import com.silo.backend.database.tables.Complexity;
import com.silo.backend.database.tables.ComplexityKind;
import com.silo.backend.database.tables.CustomEnvironment;
import com.silo.backend.database.tables.CustomEnvironmentUsage;
import com.silo.backend.database.tables.DatabaseInformation;
import com.silo.backend.database.tables.DatabaseUsage;
import com.silo.backend.database.tables.Involvement;
import com.silo.backend.database.tables.InvolvementGroup;
import com.silo.backend.database.tables.InvolvementGroupEntry;
import com.silo.backend.database.tables.InvolvementKind;
import com.silo.backend.database.tables.KeyInvolvementKind;
import com.silo.backend.database.tables.OrganisationalUnit;
import com.silo.backend.database.tables.PermissionGroup;
import com.silo.backend.database.tables.PermissionGroupEntry;
import com.silo.backend.database.tables.PermissionGroupInvolvement;
import com.silo.backend.database.tables.Person;
import com.silo.backend.database.tables.PersonHierarchy;
import com.silo.backend.database.tables.RelationshipKind;
import com.silo.backend.database.tables.Role;
import com.silo.backend.database.tables.ServerInformation;
import com.silo.backend.database.tables.ServerUsage;
import com.silo.backend.database.tables.Settings;
import com.silo.backend.database.tables.Thumbnail;
import com.silo.backend.database.tables.User;
import com.silo.backend.database.tables.UserAgentInfo;
import com.silo.backend.database.tables.UserPreference;
import com.silo.backend.database.tables.UserRole;

import jakarta.annotation.Nonnull;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * logs user page and section views
     */
    public final AccessLog ACCESS_LOG = AccessLog.ACCESS_LOG;

    /**
     * represents a non application entity, typically used in flows.  Examples
     * include exchanges, departments, counterpart organisations
     */
    public final Actor ACTOR = Actor.ACTOR;

    /**
     * represents an application (with an entity_kind of 'APPLICATION')
     */
    public final Application APPLICATION = Application.APPLICATION;

    /**
     * The table <code>application_component</code>.
     */
    public final ApplicationComponent APPLICATION_COMPONENT = ApplicationComponent.APPLICATION_COMPONENT;

    /**
     * represents an ad-hoc collection of applications
     */
    public final ApplicationGroup APPLICATION_GROUP = ApplicationGroup.APPLICATION_GROUP;

    /**
     * a reference to a specific application in a group
     */
    public final ApplicationGroupEntry APPLICATION_GROUP_ENTRY = ApplicationGroupEntry.APPLICATION_GROUP_ENTRY;

    /**
     * users granted viewer or ownership rights to app groups
     */
    public final ApplicationGroupMember APPLICATION_GROUP_MEMBER = ApplicationGroupMember.APPLICATION_GROUP_MEMBER;

    /**
     * app groups can include reference to org units. Apps associated to the org
     * unit are included in the group at runtime
     */
    public final ApplicationGroupOuEntry APPLICATION_GROUP_OU_ENTRY = ApplicationGroupOuEntry.APPLICATION_GROUP_OU_ENTRY;

    /**
     * The table <code>application_relationship</code>.
     */
    public final ApplicationRelationship APPLICATION_RELATIONSHIP = ApplicationRelationship.APPLICATION_RELATIONSHIP;

    /**
     * a score of a given complexity kind for an entity in waltz
     */
    public final Complexity COMPLEXITY = Complexity.COMPLEXITY;

    /**
     * complexity can be used to give a decimal score for an entity in waltz
     * against a complexity kind (e.g. Flow Complexity). The complexity kind
     * describes the type of complexity being evaluated.
     */
    public final ComplexityKind COMPLEXITY_KIND = ComplexityKind.COMPLEXITY_KIND;

    /**
     * The table <code>custom_environment</code>.
     */
    public final CustomEnvironment CUSTOM_ENVIRONMENT = CustomEnvironment.CUSTOM_ENVIRONMENT;

    /**
     * The table <code>custom_environment_usage</code>.
     */
    public final CustomEnvironmentUsage CUSTOM_ENVIRONMENT_USAGE = CustomEnvironmentUsage.CUSTOM_ENVIRONMENT_USAGE;

    /**
     * The table <code>database_information</code>.
     */
    public final DatabaseInformation DATABASE_INFORMATION = DatabaseInformation.DATABASE_INFORMATION;

    /**
     * The table <code>database_usage</code>.
     */
    public final DatabaseUsage DATABASE_USAGE = DatabaseUsage.DATABASE_USAGE;

    /**
     * defines a specific instance of an involvement kind between a person and
     * an entity (e.g. 'User X' is 'IT Owner' for 'APPLICATION/32')
     */
    public final Involvement INVOLVEMENT = Involvement.INVOLVEMENT;

    /**
     * collection of involvement kinds
     */
    public final InvolvementGroup INVOLVEMENT_GROUP = InvolvementGroup.INVOLVEMENT_GROUP;

    /**
     * describes the association of an involvement kind to an involvement group
     */
    public final InvolvementGroupEntry INVOLVEMENT_GROUP_ENTRY = InvolvementGroupEntry.INVOLVEMENT_GROUP_ENTRY;

    /**
     * defines a particular type of involvement a person may have in relation to
     * an entity (e.g. IT Owner for an APPLICATION)
     */
    public final InvolvementKind INVOLVEMENT_KIND = InvolvementKind.INVOLVEMENT_KIND;

    /**
     * Key Involvement Kind For Entity Kind
     */
    public final KeyInvolvementKind KEY_INVOLVEMENT_KIND = KeyInvolvementKind.KEY_INVOLVEMENT_KIND;

    /**
     * The table <code>organisational_unit</code>.
     */
    public final OrganisationalUnit ORGANISATIONAL_UNIT = OrganisationalUnit.ORGANISATIONAL_UNIT;

    /**
     * group describing the permissions different involvement kinds have against
     * waltz entities
     */
    public final PermissionGroup PERMISSION_GROUP = PermissionGroup.PERMISSION_GROUP;

    /**
     * entities which have specific permissions which replace the default
     * permission group
     */
    public final PermissionGroupEntry PERMISSION_GROUP_ENTRY = PermissionGroupEntry.PERMISSION_GROUP_ENTRY;

    /**
     * links a group of involvements to a given operation on an entity kind
     */
    public final PermissionGroupInvolvement PERMISSION_GROUP_INVOLVEMENT = PermissionGroupInvolvement.PERMISSION_GROUP_INVOLVEMENT;

    /**
     * The table <code>person</code>.
     */
    public final Person PERSON = Person.PERSON;

    /**
     * The table <code>person_hierarchy</code>.
     */
    public final PersonHierarchy PERSON_HIERARCHY = PersonHierarchy.PERSON_HIERARCHY;

    /**
     * Describes types of relationships between entities
     */
    public final RelationshipKind RELATIONSHIP_KIND = RelationshipKind.RELATIONSHIP_KIND;

    /**
     * The table <code>role</code>.
     */
    public final Role ROLE = Role.ROLE;

    /**
     * The table <code>server_information</code>.
     */
    public final ServerInformation SERVER_INFORMATION = ServerInformation.SERVER_INFORMATION;

    /**
     * The table <code>server_usage</code>.
     */
    public final ServerUsage SERVER_USAGE = ServerUsage.SERVER_USAGE;

    /**
     * contains configuration data which controls the operation of Waltz.
     */
    public final Settings SETTINGS = Settings.SETTINGS;

    /**
     * The table <code>thumbnail</code>.
     */
    public final Thumbnail THUMBNAIL = Thumbnail.THUMBNAIL;

    /**
     * The table <code>user</code>.
     */
    public final User USER = User.USER;

    /**
     * The table <code>user_agent_info</code>.
     */
    public final UserAgentInfo USER_AGENT_INFO = UserAgentInfo.USER_AGENT_INFO;

    /**
     * The table <code>user_preference</code>.
     */
    public final UserPreference USER_PREFERENCE = UserPreference.USER_PREFERENCE;

    /**
     * The table <code>user_role</code>.
     */
    public final UserRole USER_ROLE = UserRole.USER_ROLE;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    @Nonnull
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    @Nonnull
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            AccessLog.ACCESS_LOG,
            Actor.ACTOR,
            Application.APPLICATION,
            ApplicationComponent.APPLICATION_COMPONENT,
            ApplicationGroup.APPLICATION_GROUP,
            ApplicationGroupEntry.APPLICATION_GROUP_ENTRY,
            ApplicationGroupMember.APPLICATION_GROUP_MEMBER,
            ApplicationGroupOuEntry.APPLICATION_GROUP_OU_ENTRY,
            ApplicationRelationship.APPLICATION_RELATIONSHIP,
            Complexity.COMPLEXITY,
            ComplexityKind.COMPLEXITY_KIND,
            CustomEnvironment.CUSTOM_ENVIRONMENT,
            CustomEnvironmentUsage.CUSTOM_ENVIRONMENT_USAGE,
            DatabaseInformation.DATABASE_INFORMATION,
            DatabaseUsage.DATABASE_USAGE,
            Involvement.INVOLVEMENT,
            InvolvementGroup.INVOLVEMENT_GROUP,
            InvolvementGroupEntry.INVOLVEMENT_GROUP_ENTRY,
            InvolvementKind.INVOLVEMENT_KIND,
            KeyInvolvementKind.KEY_INVOLVEMENT_KIND,
            OrganisationalUnit.ORGANISATIONAL_UNIT,
            PermissionGroup.PERMISSION_GROUP,
            PermissionGroupEntry.PERMISSION_GROUP_ENTRY,
            PermissionGroupInvolvement.PERMISSION_GROUP_INVOLVEMENT,
            Person.PERSON,
            PersonHierarchy.PERSON_HIERARCHY,
            RelationshipKind.RELATIONSHIP_KIND,
            Role.ROLE,
            ServerInformation.SERVER_INFORMATION,
            ServerUsage.SERVER_USAGE,
            Settings.SETTINGS,
            Thumbnail.THUMBNAIL,
            User.USER,
            UserAgentInfo.USER_AGENT_INFO,
            UserPreference.USER_PREFERENCE,
            UserRole.USER_ROLE
        );
    }
}
