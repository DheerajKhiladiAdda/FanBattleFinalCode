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
public class com_khiladiadda_in_network_model_response_PointDetailsRealmProxy extends com.khiladiadda.in.network.model.response.PointDetails
    implements RealmObjectProxy, com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface {

    static final class PointDetailsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long imageIndex;
        long textIndex;

        PointDetailsColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PointDetails");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.imageIndex = addColumnDetails("image", "image", objectSchemaInfo);
            this.textIndex = addColumnDetails("text", "text", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PointDetailsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PointDetailsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PointDetailsColumnInfo src = (PointDetailsColumnInfo) rawSrc;
            final PointDetailsColumnInfo dst = (PointDetailsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.imageIndex = src.imageIndex;
            dst.textIndex = src.textIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PointDetailsColumnInfo columnInfo;
    private ProxyState<com.khiladiadda.in.network.model.response.PointDetails> proxyState;

    com_khiladiadda_in_network_model_response_PointDetailsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PointDetailsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.khiladiadda.in.network.model.response.PointDetails>(this);
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
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    @Override
    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$text() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.textIndex);
    }

    @Override
    public void realmSet$text(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.textIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.textIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.textIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.textIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PointDetails", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("text", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PointDetailsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PointDetailsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PointDetails";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PointDetails";
    }

    @SuppressWarnings("cast")
    public static com.khiladiadda.in.network.model.response.PointDetails createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.khiladiadda.in.network.model.response.PointDetails obj = null;
        if (update) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
            PointDetailsColumnInfo columnInfo = (PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.response.PointDetails.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.response.PointDetails.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) obj;
        if (json.has("image")) {
            if (json.isNull("image")) {
                objProxy.realmSet$image(null);
            } else {
                objProxy.realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("text")) {
            if (json.isNull("text")) {
                objProxy.realmSet$text(null);
            } else {
                objProxy.realmSet$text((String) json.getString("text"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.khiladiadda.in.network.model.response.PointDetails createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.khiladiadda.in.network.model.response.PointDetails obj = new com.khiladiadda.in.network.model.response.PointDetails();
        final com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) obj;
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
            } else if (name.equals("image")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$image(null);
                }
            } else if (name.equals("text")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$text((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$text(null);
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

    private static com_khiladiadda_in_network_model_response_PointDetailsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class), false, Collections.<String>emptyList());
        io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy obj = new io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.khiladiadda.in.network.model.response.PointDetails copyOrUpdate(Realm realm, PointDetailsColumnInfo columnInfo, com.khiladiadda.in.network.model.response.PointDetails object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.khiladiadda.in.network.model.response.PointDetails) cachedRealmObject;
        }

        com.khiladiadda.in.network.model.response.PointDetails realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$id();
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
                    realmObject = new io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.khiladiadda.in.network.model.response.PointDetails copy(Realm realm, PointDetailsColumnInfo columnInfo, com.khiladiadda.in.network.model.response.PointDetails newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.khiladiadda.in.network.model.response.PointDetails) cachedRealmObject;
        }

        com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.imageIndex, realmObjectSource.realmGet$image());
        builder.addString(columnInfo.textIndex, realmObjectSource.realmGet$text());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_khiladiadda_in_network_model_response_PointDetailsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.khiladiadda.in.network.model.response.PointDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        long tableNativePtr = table.getNativePtr();
        PointDetailsColumnInfo columnInfo = (PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$id();
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
        String realmGet$image = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        String realmGet$text = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        long tableNativePtr = table.getNativePtr();
        PointDetailsColumnInfo columnInfo = (PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.khiladiadda.in.network.model.response.PointDetails object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.response.PointDetails) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$id();
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
            String realmGet$image = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            }
            String realmGet$text = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$text();
            if (realmGet$text != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.khiladiadda.in.network.model.response.PointDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        long tableNativePtr = table.getNativePtr();
        PointDetailsColumnInfo columnInfo = (PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$id();
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
        String realmGet$image = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        String realmGet$text = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        long tableNativePtr = table.getNativePtr();
        PointDetailsColumnInfo columnInfo = (PointDetailsColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.response.PointDetails.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.khiladiadda.in.network.model.response.PointDetails object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.response.PointDetails) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$id();
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
            String realmGet$image = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
            }
            String realmGet$text = ((com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) object).realmGet$text();
            if (realmGet$text != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
            }
        }
    }

    public static com.khiladiadda.in.network.model.response.PointDetails createDetachedCopy(com.khiladiadda.in.network.model.response.PointDetails realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.khiladiadda.in.network.model.response.PointDetails unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.khiladiadda.in.network.model.response.PointDetails();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.khiladiadda.in.network.model.response.PointDetails) cachedObject.object;
            }
            unmanagedObject = (com.khiladiadda.in.network.model.response.PointDetails) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface unmanagedCopy = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) unmanagedObject;
        com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface realmSource = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$image(realmSource.realmGet$image());
        unmanagedCopy.realmSet$text(realmSource.realmGet$text());

        return unmanagedObject;
    }

    static com.khiladiadda.in.network.model.response.PointDetails update(Realm realm, PointDetailsColumnInfo columnInfo, com.khiladiadda.in.network.model.response.PointDetails realmObject, com.khiladiadda.in.network.model.response.PointDetails newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface realmObjectTarget = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) realmObject;
        com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxyInterface) newObject;
        Table table = realm.getTable(com.khiladiadda.in.network.model.response.PointDetails.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.imageIndex, realmObjectSource.realmGet$image());
        builder.addString(columnInfo.textIndex, realmObjectSource.realmGet$text());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PointDetails = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{text:");
        stringBuilder.append(realmGet$text() != null ? realmGet$text() : "null");
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
        com_khiladiadda_in_network_model_response_PointDetailsRealmProxy aPointDetails = (com_khiladiadda_in_network_model_response_PointDetailsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPointDetails.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPointDetails.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPointDetails.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
