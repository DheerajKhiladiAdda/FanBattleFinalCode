package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_khiladiadda_in_network_model_response_FactsListRealmProxy extends com.khiladiadda.in.network.model.response.FactsList
    implements RealmObjectProxy, com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface {

    static final class FactsListColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long likeIndex;
        long bookmarkIndex;
        long viewsIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long dateIndex;
        long detailsIndex;
        long fromIndex;
        long headingIndex;
        long imgurlIndex;
        long subheadingIndex;
        long typeIndex;
        long pointsIndex;
        long likedIndex;
        long bookmarkedIndex;

        FactsListColumnInfo(OsSchemaInfo schemaInfo) {
            super(16);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("FactsList");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.likeIndex = addColumnDetails("like", "like", objectSchemaInfo);
            this.bookmarkIndex = addColumnDetails("bookmark", "bookmark", objectSchemaInfo);
            this.viewsIndex = addColumnDetails("views", "views", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.updatedAtIndex = addColumnDetails("updatedAt", "updatedAt", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.detailsIndex = addColumnDetails("details", "details", objectSchemaInfo);
            this.fromIndex = addColumnDetails("from", "from", objectSchemaInfo);
            this.headingIndex = addColumnDetails("heading", "heading", objectSchemaInfo);
            this.imgurlIndex = addColumnDetails("imgurl", "imgurl", objectSchemaInfo);
            this.subheadingIndex = addColumnDetails("subheading", "subheading", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.pointsIndex = addColumnDetails("points", "points", objectSchemaInfo);
            this.likedIndex = addColumnDetails("liked", "liked", objectSchemaInfo);
            this.bookmarkedIndex = addColumnDetails("bookmarked", "bookmarked", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        FactsListColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FactsListColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FactsListColumnInfo src = (FactsListColumnInfo) rawSrc;
            final FactsListColumnInfo dst = (FactsListColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.likeIndex = src.likeIndex;
            dst.bookmarkIndex = src.bookmarkIndex;
            dst.viewsIndex = src.viewsIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.dateIndex = src.dateIndex;
            dst.detailsIndex = src.detailsIndex;
            dst.fromIndex = src.fromIndex;
            dst.headingIndex = src.headingIndex;
            dst.imgurlIndex = src.imgurlIndex;
            dst.subheadingIndex = src.subheadingIndex;
            dst.typeIndex = src.typeIndex;
            dst.pointsIndex = src.pointsIndex;
            dst.likedIndex = src.likedIndex;
            dst.bookmarkedIndex = src.bookmarkedIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private FactsListColumnInfo columnInfo;
    private ProxyState<com.khiladiadda.in.network.model.response.FactsList> proxyState;
    private RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsRealmList;

    com_khiladiadda_in_network_model_response_FactsListRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FactsListColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.khiladiadda.in.network.model.response.FactsList>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$like() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.likeIndex);
    }

    @Override
    public void realmSet$like(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.likeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.likeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$bookmark() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.bookmarkIndex);
    }

    @Override
    public void realmSet$bookmark(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.bookmarkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.bookmarkIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$views() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.viewsIndex);
    }

    @Override
    public void realmSet$views(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.viewsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.viewsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdAtIndex);
    }

    @Override
    public void realmSet$createdAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updatedAtIndex);
    }

    @Override
    public void realmSet$updatedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updatedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updatedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updatedAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$details() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.detailsIndex);
    }

    @Override
    public void realmSet$details(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.detailsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.detailsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.detailsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.detailsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$from() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromIndex);
    }

    @Override
    public void realmSet$from(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$heading() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.headingIndex);
    }

    @Override
    public void realmSet$heading(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.headingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.headingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.headingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.headingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$imgurl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imgurlIndex);
    }

    @Override
    public void realmSet$imgurl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imgurlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imgurlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imgurlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imgurlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$subheading() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.subheadingIndex);
    }

    @Override
    public void realmSet$subheading(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.subheadingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.subheadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.subheadingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.subheadingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    public RealmList<com.khiladiadda.in.network.model.response.PointDetails> realmGet$points() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (pointsRealmList != null) {
            return pointsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.pointsIndex);
            pointsRealmList = new RealmList<com.khiladiadda.in.network.model.response.PointDetails>(com.khiladiadda.in.network.model.response.PointDetails.class, osList, proxyState.getRealm$realm());
            return pointsRealmList;
        }
    }

    @Override
    public void realmSet$points(RealmList<com.khiladiadda.in.network.model.response.PointDetails> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("points")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.khiladiadda.in.network.model.response.PointDetails> original = value;
                value = new RealmList<com.khiladiadda.in.network.model.response.PointDetails>();
                for (com.khiladiadda.in.network.model.response.PointDetails item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.pointsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.khiladiadda.in.network.model.response.PointDetails linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.khiladiadda.in.network.model.response.PointDetails linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$liked() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.likedIndex);
    }

    @Override
    public void realmSet$liked(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.likedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.likedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$bookmarked() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.bookmarkedIndex);
    }

    @Override
    public void realmSet$bookmarked(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.bookmarkedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.bookmarkedIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FactsList", 16, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("like", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bookmark", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("views", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("details", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("from", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("heading", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("imgurl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("subheading", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("points", RealmFieldType.LIST, "PointDetails");
        builder.addPersistedProperty("liked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bookmarked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FactsListColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FactsListColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "FactsList";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "FactsList";
    }

    @SuppressWarnings("cast")
    public static com.khiladiadda.in.network.model.response.FactsList createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.khiladiadda.in.network.model.response.FactsList obj = null;
        if (update) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
            FactsListColumnInfo columnInfo = (FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("points")) {
                excludeFields.add("points");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.response.FactsList.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.response.FactsList.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) obj;
        if (json.has("like")) {
            if (json.isNull("like")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'like' to null.");
            } else {
                objProxy.realmSet$like((long) json.getLong("like"));
            }
        }
        if (json.has("bookmark")) {
            if (json.isNull("bookmark")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bookmark' to null.");
            } else {
                objProxy.realmSet$bookmark((long) json.getLong("bookmark"));
            }
        }
        if (json.has("views")) {
            if (json.isNull("views")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'views' to null.");
            } else {
                objProxy.realmSet$views((long) json.getLong("views"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                objProxy.realmSet$createdAt(null);
            } else {
                objProxy.realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                objProxy.realmSet$updatedAt(null);
            } else {
                objProxy.realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                objProxy.realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("details")) {
            if (json.isNull("details")) {
                objProxy.realmSet$details(null);
            } else {
                objProxy.realmSet$details((String) json.getString("details"));
            }
        }
        if (json.has("from")) {
            if (json.isNull("from")) {
                objProxy.realmSet$from(null);
            } else {
                objProxy.realmSet$from((String) json.getString("from"));
            }
        }
        if (json.has("heading")) {
            if (json.isNull("heading")) {
                objProxy.realmSet$heading(null);
            } else {
                objProxy.realmSet$heading((String) json.getString("heading"));
            }
        }
        if (json.has("imgurl")) {
            if (json.isNull("imgurl")) {
                objProxy.realmSet$imgurl(null);
            } else {
                objProxy.realmSet$imgurl((String) json.getString("imgurl"));
            }
        }
        if (json.has("subheading")) {
            if (json.isNull("subheading")) {
                objProxy.realmSet$subheading(null);
            } else {
                objProxy.realmSet$subheading((String) json.getString("subheading"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("points")) {
            if (json.isNull("points")) {
                objProxy.realmSet$points(null);
            } else {
                objProxy.realmGet$points().clear();
                JSONArray array = json.getJSONArray("points");
                for (int i = 0; i < array.length(); i++) {
                    com.khiladiadda.in.network.model.response.PointDetails item = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$points().add(item);
                }
            }
        }
        if (json.has("liked")) {
            if (json.isNull("liked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'liked' to null.");
            } else {
                objProxy.realmSet$liked((boolean) json.getBoolean("liked"));
            }
        }
        if (json.has("bookmarked")) {
            if (json.isNull("bookmarked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bookmarked' to null.");
            } else {
                objProxy.realmSet$bookmarked((boolean) json.getBoolean("bookmarked"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.khiladiadda.in.network.model.response.FactsList createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.khiladiadda.in.network.model.response.FactsList obj = new com.khiladiadda.in.network.model.response.FactsList();
        final com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("like")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$like((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'like' to null.");
                }
            } else if (name.equals("bookmark")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bookmark((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bookmark' to null.");
                }
            } else if (name.equals("views")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$views((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'views' to null.");
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdAt(null);
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updatedAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updatedAt(null);
                }
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                }
            } else if (name.equals("details")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$details((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$details(null);
                }
            } else if (name.equals("from")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$from((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$from(null);
                }
            } else if (name.equals("heading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$heading((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$heading(null);
                }
            } else if (name.equals("imgurl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$imgurl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$imgurl(null);
                }
            } else if (name.equals("subheading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$subheading((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$subheading(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("points")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$points(null);
                } else {
                    objProxy.realmSet$points(new RealmList<com.khiladiadda.in.network.model.response.PointDetails>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.khiladiadda.in.network.model.response.PointDetails item = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$points().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("liked")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$liked((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'liked' to null.");
                }
            } else if (name.equals("bookmarked")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bookmarked((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bookmarked' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_khiladiadda_in_network_model_response_FactsListRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class), false, Collections.<String>emptyList());
        io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy obj = new io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.khiladiadda.in.network.model.response.FactsList copyOrUpdate(Realm realm, FactsListColumnInfo columnInfo, com.khiladiadda.in.network.model.response.FactsList object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.khiladiadda.in.network.model.response.FactsList) cachedRealmObject;
        }

        com.khiladiadda.in.network.model.response.FactsList realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.khiladiadda.in.network.model.response.FactsList copy(Realm realm, FactsListColumnInfo columnInfo, com.khiladiadda.in.network.model.response.FactsList newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.khiladiadda.in.network.model.response.FactsList) cachedRealmObject;
        }

        com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) newObject;

        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.likeIndex, realmObjectSource.realmGet$like());
        builder.addInteger(columnInfo.bookmarkIndex, realmObjectSource.realmGet$bookmark());
        builder.addInteger(columnInfo.viewsIndex, realmObjectSource.realmGet$views());
        builder.addString(columnInfo.createdAtIndex, realmObjectSource.realmGet$createdAt());
        builder.addString(columnInfo.updatedAtIndex, realmObjectSource.realmGet$updatedAt());
        builder.addString(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.detailsIndex, realmObjectSource.realmGet$details());
        builder.addString(columnInfo.fromIndex, realmObjectSource.realmGet$from());
        builder.addString(columnInfo.headingIndex, realmObjectSource.realmGet$heading());
        builder.addString(columnInfo.imgurlIndex, realmObjectSource.realmGet$imgurl());
        builder.addString(columnInfo.subheadingIndex, realmObjectSource.realmGet$subheading());
        builder.addString(columnInfo.typeIndex, realmObjectSource.realmGet$type());
        builder.addBoolean(columnInfo.likedIndex, realmObjectSource.realmGet$liked());
        builder.addBoolean(columnInfo.bookmarkedIndex, realmObjectSource.realmGet$bookmarked());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_khiladiadda_in_network_model_response_FactsListRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = realmObjectSource.realmGet$points();
        if (pointsList != null) {
            RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsRealmList = realmObjectCopy.realmGet$points();
            pointsRealmList.clear();
            for (int i = 0; i < pointsList.size(); i++) {
                com.khiladiadda.in.network.model.response.PointDetails pointsItem = pointsList.get(i);
                com.khiladiadda.in.network.model.response.PointDetails cachepoints = (com.khiladiadda.in.network.model.response.PointDetails) cache.get(pointsItem);
                if (cachepoints != null) {
                    pointsRealmList.add(cachepoints);
                } else {
                    pointsRealmList.add(com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.copyOrUpdate(realm, (com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class), pointsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.khiladiadda.in.network.model.response.FactsList object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        long tableNativePtr = table.getNativePtr();
        FactsListColumnInfo columnInfo = (FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.likeIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$like(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.bookmarkIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmark(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewsIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$views(), false);
        String realmGet$createdAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$date = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        String realmGet$details = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$details();
        if (realmGet$details != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailsIndex, rowIndex, realmGet$details, false);
        }
        String realmGet$from = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$from();
        if (realmGet$from != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
        }
        String realmGet$heading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$heading();
        if (realmGet$heading != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.headingIndex, rowIndex, realmGet$heading, false);
        }
        String realmGet$imgurl = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$imgurl();
        if (realmGet$imgurl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgurlIndex, rowIndex, realmGet$imgurl, false);
        }
        String realmGet$subheading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$subheading();
        if (realmGet$subheading != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subheadingIndex, rowIndex, realmGet$subheading, false);
        }
        String realmGet$type = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }

        RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$points();
        if (pointsList != null) {
            OsList pointsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pointsIndex);
            for (com.khiladiadda.in.network.model.response.PointDetails pointsItem : pointsList) {
                Long cacheItemIndexpoints = cache.get(pointsItem);
                if (cacheItemIndexpoints == null) {
                    cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insert(realm, pointsItem, cache);
                }
                pointsOsList.addRow(cacheItemIndexpoints);
            }
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.likedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$liked(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bookmarkedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmarked(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        long tableNativePtr = table.getNativePtr();
        FactsListColumnInfo columnInfo = (FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.khiladiadda.in.network.model.response.FactsList object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.response.FactsList) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.likeIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$like(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.bookmarkIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmark(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.viewsIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$views(), false);
            String realmGet$createdAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updatedAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            }
            String realmGet$date = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            }
            String realmGet$details = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$details();
            if (realmGet$details != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detailsIndex, rowIndex, realmGet$details, false);
            }
            String realmGet$from = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$from();
            if (realmGet$from != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
            }
            String realmGet$heading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$heading();
            if (realmGet$heading != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.headingIndex, rowIndex, realmGet$heading, false);
            }
            String realmGet$imgurl = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$imgurl();
            if (realmGet$imgurl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imgurlIndex, rowIndex, realmGet$imgurl, false);
            }
            String realmGet$subheading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$subheading();
            if (realmGet$subheading != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subheadingIndex, rowIndex, realmGet$subheading, false);
            }
            String realmGet$type = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }

            RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$points();
            if (pointsList != null) {
                OsList pointsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pointsIndex);
                for (com.khiladiadda.in.network.model.response.PointDetails pointsItem : pointsList) {
                    Long cacheItemIndexpoints = cache.get(pointsItem);
                    if (cacheItemIndexpoints == null) {
                        cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insert(realm, pointsItem, cache);
                    }
                    pointsOsList.addRow(cacheItemIndexpoints);
                }
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.likedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$liked(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bookmarkedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmarked(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.khiladiadda.in.network.model.response.FactsList object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        long tableNativePtr = table.getNativePtr();
        FactsListColumnInfo columnInfo = (FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.likeIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$like(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.bookmarkIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmark(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewsIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$views(), false);
        String realmGet$createdAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$date = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$details = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$details();
        if (realmGet$details != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailsIndex, rowIndex, realmGet$details, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.detailsIndex, rowIndex, false);
        }
        String realmGet$from = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$from();
        if (realmGet$from != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromIndex, rowIndex, false);
        }
        String realmGet$heading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$heading();
        if (realmGet$heading != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.headingIndex, rowIndex, realmGet$heading, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.headingIndex, rowIndex, false);
        }
        String realmGet$imgurl = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$imgurl();
        if (realmGet$imgurl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgurlIndex, rowIndex, realmGet$imgurl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imgurlIndex, rowIndex, false);
        }
        String realmGet$subheading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$subheading();
        if (realmGet$subheading != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subheadingIndex, rowIndex, realmGet$subheading, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.subheadingIndex, rowIndex, false);
        }
        String realmGet$type = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }

        OsList pointsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pointsIndex);
        RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$points();
        if (pointsList != null && pointsList.size() == pointsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = pointsList.size();
            for (int i = 0; i < objects; i++) {
                com.khiladiadda.in.network.model.response.PointDetails pointsItem = pointsList.get(i);
                Long cacheItemIndexpoints = cache.get(pointsItem);
                if (cacheItemIndexpoints == null) {
                    cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, pointsItem, cache);
                }
                pointsOsList.setRow(i, cacheItemIndexpoints);
            }
        } else {
            pointsOsList.removeAll();
            if (pointsList != null) {
                for (com.khiladiadda.in.network.model.response.PointDetails pointsItem : pointsList) {
                    Long cacheItemIndexpoints = cache.get(pointsItem);
                    if (cacheItemIndexpoints == null) {
                        cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, pointsItem, cache);
                    }
                    pointsOsList.addRow(cacheItemIndexpoints);
                }
            }
        }

        Table.nativeSetBoolean(tableNativePtr, columnInfo.likedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$liked(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.bookmarkedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmarked(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        long tableNativePtr = table.getNativePtr();
        FactsListColumnInfo columnInfo = (FactsListColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.FactsList.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.khiladiadda.in.network.model.response.FactsList object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.response.FactsList) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.likeIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$like(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.bookmarkIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmark(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.viewsIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$views(), false);
            String realmGet$createdAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updatedAt = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$updatedAt();
            if (realmGet$updatedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
            }
            String realmGet$date = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
            }
            String realmGet$details = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$details();
            if (realmGet$details != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detailsIndex, rowIndex, realmGet$details, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.detailsIndex, rowIndex, false);
            }
            String realmGet$from = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$from();
            if (realmGet$from != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromIndex, rowIndex, false);
            }
            String realmGet$heading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$heading();
            if (realmGet$heading != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.headingIndex, rowIndex, realmGet$heading, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.headingIndex, rowIndex, false);
            }
            String realmGet$imgurl = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$imgurl();
            if (realmGet$imgurl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imgurlIndex, rowIndex, realmGet$imgurl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imgurlIndex, rowIndex, false);
            }
            String realmGet$subheading = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$subheading();
            if (realmGet$subheading != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subheadingIndex, rowIndex, realmGet$subheading, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.subheadingIndex, rowIndex, false);
            }
            String realmGet$type = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }

            OsList pointsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pointsIndex);
            RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$points();
            if (pointsList != null && pointsList.size() == pointsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = pointsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.khiladiadda.in.network.model.response.PointDetails pointsItem = pointsList.get(i);
                    Long cacheItemIndexpoints = cache.get(pointsItem);
                    if (cacheItemIndexpoints == null) {
                        cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, pointsItem, cache);
                    }
                    pointsOsList.setRow(i, cacheItemIndexpoints);
                }
            } else {
                pointsOsList.removeAll();
                if (pointsList != null) {
                    for (com.khiladiadda.in.network.model.response.PointDetails pointsItem : pointsList) {
                        Long cacheItemIndexpoints = cache.get(pointsItem);
                        if (cacheItemIndexpoints == null) {
                            cacheItemIndexpoints = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.insertOrUpdate(realm, pointsItem, cache);
                        }
                        pointsOsList.addRow(cacheItemIndexpoints);
                    }
                }
            }

            Table.nativeSetBoolean(tableNativePtr, columnInfo.likedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$liked(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bookmarkedIndex, rowIndex, ((com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) object).realmGet$bookmarked(), false);
        }
    }

    public static com.khiladiadda.in.network.model.response.FactsList createDetachedCopy(com.khiladiadda.in.network.model.response.FactsList realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.khiladiadda.in.network.model.response.FactsList unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.khiladiadda.in.network.model.response.FactsList();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.khiladiadda.in.network.model.response.FactsList) cachedObject.object;
            }
            unmanagedObject = (com.khiladiadda.in.network.model.response.FactsList) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface unmanagedCopy = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) unmanagedObject;
        com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface realmSource = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$like(realmSource.realmGet$like());
        unmanagedCopy.realmSet$bookmark(realmSource.realmGet$bookmark());
        unmanagedCopy.realmSet$views(realmSource.realmGet$views());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updatedAt(realmSource.realmGet$updatedAt());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$details(realmSource.realmGet$details());
        unmanagedCopy.realmSet$from(realmSource.realmGet$from());
        unmanagedCopy.realmSet$heading(realmSource.realmGet$heading());
        unmanagedCopy.realmSet$imgurl(realmSource.realmGet$imgurl());
        unmanagedCopy.realmSet$subheading(realmSource.realmGet$subheading());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());

        // Deep copy of points
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$points(null);
        } else {
            RealmList<com.khiladiadda.in.network.model.response.PointDetails> managedpointsList = realmSource.realmGet$points();
            RealmList<com.khiladiadda.in.network.model.response.PointDetails> unmanagedpointsList = new RealmList<com.khiladiadda.in.network.model.response.PointDetails>();
            unmanagedCopy.realmSet$points(unmanagedpointsList);
            int nextDepth = currentDepth + 1;
            int size = managedpointsList.size();
            for (int i = 0; i < size; i++) {
                com.khiladiadda.in.network.model.response.PointDetails item = com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.createDetachedCopy(managedpointsList.get(i), nextDepth, maxDepth, cache);
                unmanagedpointsList.add(item);
            }
        }
        unmanagedCopy.realmSet$liked(realmSource.realmGet$liked());
        unmanagedCopy.realmSet$bookmarked(realmSource.realmGet$bookmarked());

        return unmanagedObject;
    }

    static com.khiladiadda.in.network.model.response.FactsList update(Realm realm, FactsListColumnInfo columnInfo, com.khiladiadda.in.network.model.response.FactsList realmObject, com.khiladiadda.in.network.model.response.FactsList newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface realmObjectTarget = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) realmObject;
        com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_response_FactsListRealmProxyInterface) newObject;
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.FactsList.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.likeIndex, realmObjectSource.realmGet$like());
        builder.addInteger(columnInfo.bookmarkIndex, realmObjectSource.realmGet$bookmark());
        builder.addInteger(columnInfo.viewsIndex, realmObjectSource.realmGet$views());
        builder.addString(columnInfo.createdAtIndex, realmObjectSource.realmGet$createdAt());
        builder.addString(columnInfo.updatedAtIndex, realmObjectSource.realmGet$updatedAt());
        builder.addString(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.detailsIndex, realmObjectSource.realmGet$details());
        builder.addString(columnInfo.fromIndex, realmObjectSource.realmGet$from());
        builder.addString(columnInfo.headingIndex, realmObjectSource.realmGet$heading());
        builder.addString(columnInfo.imgurlIndex, realmObjectSource.realmGet$imgurl());
        builder.addString(columnInfo.subheadingIndex, realmObjectSource.realmGet$subheading());
        builder.addString(columnInfo.typeIndex, realmObjectSource.realmGet$type());

        RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsList = realmObjectSource.realmGet$points();
        if (pointsList != null) {
            RealmList<com.khiladiadda.in.network.model.response.PointDetails> pointsManagedCopy = new RealmList<com.khiladiadda.in.network.model.response.PointDetails>();
            for (int i = 0; i < pointsList.size(); i++) {
                com.khiladiadda.in.network.model.response.PointDetails pointsItem = pointsList.get(i);
                com.khiladiadda.in.network.model.response.PointDetails cachepoints = (com.khiladiadda.in.network.model.response.PointDetails) cache.get(pointsItem);
                if (cachepoints != null) {
                    pointsManagedCopy.add(cachepoints);
                } else {
                    pointsManagedCopy.add(com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.copyOrUpdate(realm, (com_khiladiadda_in_network_model_response_PointDetailsRealmProxy.PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class), pointsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.pointsIndex, pointsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.pointsIndex, new RealmList<com.khiladiadda.in.network.model.response.PointDetails>());
        }
        builder.addBoolean(columnInfo.likedIndex, realmObjectSource.realmGet$liked());
        builder.addBoolean(columnInfo.bookmarkedIndex, realmObjectSource.realmGet$bookmarked());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FactsList = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{like:");
        stringBuilder.append(realmGet$like());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bookmark:");
        stringBuilder.append(realmGet$bookmark());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{views:");
        stringBuilder.append(realmGet$views());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedAt:");
        stringBuilder.append(realmGet$updatedAt() != null ? realmGet$updatedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{details:");
        stringBuilder.append(realmGet$details() != null ? realmGet$details() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{from:");
        stringBuilder.append(realmGet$from() != null ? realmGet$from() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{heading:");
        stringBuilder.append(realmGet$heading() != null ? realmGet$heading() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imgurl:");
        stringBuilder.append(realmGet$imgurl() != null ? realmGet$imgurl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subheading:");
        stringBuilder.append(realmGet$subheading() != null ? realmGet$subheading() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{points:");
        stringBuilder.append("RealmList<PointDetails>[").append(realmGet$points().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{liked:");
        stringBuilder.append(realmGet$liked());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bookmarked:");
        stringBuilder.append(realmGet$bookmarked());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_khiladiadda_in_network_model_response_FactsListRealmProxy aFactsList = (com_khiladiadda_in_network_model_response_FactsListRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFactsList.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFactsList.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFactsList.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
