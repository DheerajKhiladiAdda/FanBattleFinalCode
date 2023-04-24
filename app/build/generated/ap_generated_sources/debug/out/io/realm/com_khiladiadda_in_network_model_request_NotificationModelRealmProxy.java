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
public class com_khiladiadda_in_network_model_request_NotificationModelRealmProxy extends com.khiladiadda.in.network.model.request.NotificationModel
    implements RealmObjectProxy, com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface {

    static final class NotificationModelColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long mIdIndex;
        long mTitleIndex;
        long mMessageIndex;
        long mDateTimeIndex;
        long mStatusIndex;

        NotificationModelColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("NotificationModel");
            this.mIdIndex = addColumnDetails("mId", "mId", objectSchemaInfo);
            this.mTitleIndex = addColumnDetails("mTitle", "mTitle", objectSchemaInfo);
            this.mMessageIndex = addColumnDetails("mMessage", "mMessage", objectSchemaInfo);
            this.mDateTimeIndex = addColumnDetails("mDateTime", "mDateTime", objectSchemaInfo);
            this.mStatusIndex = addColumnDetails("mStatus", "mStatus", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        NotificationModelColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NotificationModelColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NotificationModelColumnInfo src = (NotificationModelColumnInfo) rawSrc;
            final NotificationModelColumnInfo dst = (NotificationModelColumnInfo) rawDst;
            dst.mIdIndex = src.mIdIndex;
            dst.mTitleIndex = src.mTitleIndex;
            dst.mMessageIndex = src.mMessageIndex;
            dst.mDateTimeIndex = src.mDateTimeIndex;
            dst.mStatusIndex = src.mStatusIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private NotificationModelColumnInfo columnInfo;
    private ProxyState<com.khiladiadda.in.network.model.request.NotificationModel> proxyState;

    com_khiladiadda_in_network_model_request_NotificationModelRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NotificationModelColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.khiladiadda.in.network.model.request.NotificationModel>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$mId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mIdIndex);
    }

    @Override
    public void realmSet$mId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'mId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mTitleIndex);
    }

    @Override
    public void realmSet$mTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mMessage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mMessageIndex);
    }

    @Override
    public void realmSet$mMessage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mMessageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mMessageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mMessageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mMessageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mDateTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mDateTimeIndex);
    }

    @Override
    public void realmSet$mDateTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mDateTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mDateTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mDateTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mDateTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$mStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mStatusIndex);
    }

    @Override
    public void realmSet$mStatus(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.mStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.mStatusIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("NotificationModel", 5, 0);
        builder.addPersistedProperty("mId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("mTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mMessage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mDateTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("mStatus", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NotificationModelColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NotificationModelColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "NotificationModel";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "NotificationModel";
    }

    @SuppressWarnings("cast")
    public static com.khiladiadda.in.network.model.request.NotificationModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.khiladiadda.in.network.model.request.NotificationModel obj = null;
        if (update) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
            NotificationModelColumnInfo columnInfo = (NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
            long pkColumnIndex = columnInfo.mIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("mId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("mId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("mId")) {
                if (json.isNull("mId")) {
                    obj = (io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.request.NotificationModel.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy) realm.createObjectInternal(com.khiladiadda.in.network.model.request.NotificationModel.class, json.getInt("mId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'mId'.");
            }
        }

        final com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) obj;
        if (json.has("mTitle")) {
            if (json.isNull("mTitle")) {
                objProxy.realmSet$mTitle(null);
            } else {
                objProxy.realmSet$mTitle((String) json.getString("mTitle"));
            }
        }
        if (json.has("mMessage")) {
            if (json.isNull("mMessage")) {
                objProxy.realmSet$mMessage(null);
            } else {
                objProxy.realmSet$mMessage((String) json.getString("mMessage"));
            }
        }
        if (json.has("mDateTime")) {
            if (json.isNull("mDateTime")) {
                objProxy.realmSet$mDateTime(null);
            } else {
                objProxy.realmSet$mDateTime((String) json.getString("mDateTime"));
            }
        }
        if (json.has("mStatus")) {
            if (json.isNull("mStatus")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mStatus' to null.");
            } else {
                objProxy.realmSet$mStatus((int) json.getInt("mStatus"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.khiladiadda.in.network.model.request.NotificationModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.khiladiadda.in.network.model.request.NotificationModel obj = new com.khiladiadda.in.network.model.request.NotificationModel();
        final com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface objProxy = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("mId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("mTitle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mTitle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mTitle(null);
                }
            } else if (name.equals("mMessage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mMessage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mMessage(null);
                }
            } else if (name.equals("mDateTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mDateTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mDateTime(null);
                }
            } else if (name.equals("mStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mStatus((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mStatus' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'mId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_khiladiadda_in_network_model_request_NotificationModelRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class), false, Collections.<String>emptyList());
        io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy obj = new io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.khiladiadda.in.network.model.request.NotificationModel copyOrUpdate(Realm realm, NotificationModelColumnInfo columnInfo, com.khiladiadda.in.network.model.request.NotificationModel object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.khiladiadda.in.network.model.request.NotificationModel) cachedRealmObject;
        }

        com.khiladiadda.in.network.model.request.NotificationModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
            long pkColumnIndex = columnInfo.mIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.khiladiadda.in.network.model.request.NotificationModel copy(Realm realm, NotificationModelColumnInfo columnInfo, com.khiladiadda.in.network.model.request.NotificationModel newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.khiladiadda.in.network.model.request.NotificationModel) cachedRealmObject;
        }

        com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) newObject;

        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.mIdIndex, realmObjectSource.realmGet$mId());
        builder.addString(columnInfo.mTitleIndex, realmObjectSource.realmGet$mTitle());
        builder.addString(columnInfo.mMessageIndex, realmObjectSource.realmGet$mMessage());
        builder.addString(columnInfo.mDateTimeIndex, realmObjectSource.realmGet$mDateTime());
        builder.addInteger(columnInfo.mStatusIndex, realmObjectSource.realmGet$mStatus());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_khiladiadda_in_network_model_request_NotificationModelRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.khiladiadda.in.network.model.request.NotificationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long tableNativePtr = table.getNativePtr();
        NotificationModelColumnInfo columnInfo = (NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long pkColumnIndex = columnInfo.mIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$mTitle = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mTitle();
        if (realmGet$mTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mTitleIndex, rowIndex, realmGet$mTitle, false);
        }
        String realmGet$mMessage = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mMessage();
        if (realmGet$mMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mMessageIndex, rowIndex, realmGet$mMessage, false);
        }
        String realmGet$mDateTime = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mDateTime();
        if (realmGet$mDateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, realmGet$mDateTime, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.mStatusIndex, rowIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mStatus(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long tableNativePtr = table.getNativePtr();
        NotificationModelColumnInfo columnInfo = (NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long pkColumnIndex = columnInfo.mIdIndex;
        com.khiladiadda.in.network.model.request.NotificationModel object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.request.NotificationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$mTitle = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mTitle();
            if (realmGet$mTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mTitleIndex, rowIndex, realmGet$mTitle, false);
            }
            String realmGet$mMessage = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mMessage();
            if (realmGet$mMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mMessageIndex, rowIndex, realmGet$mMessage, false);
            }
            String realmGet$mDateTime = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mDateTime();
            if (realmGet$mDateTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, realmGet$mDateTime, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.mStatusIndex, rowIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mStatus(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.khiladiadda.in.network.model.request.NotificationModel object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long tableNativePtr = table.getNativePtr();
        NotificationModelColumnInfo columnInfo = (NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long pkColumnIndex = columnInfo.mIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
        }
        cache.put(object, rowIndex);
        String realmGet$mTitle = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mTitle();
        if (realmGet$mTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mTitleIndex, rowIndex, realmGet$mTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mTitleIndex, rowIndex, false);
        }
        String realmGet$mMessage = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mMessage();
        if (realmGet$mMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mMessageIndex, rowIndex, realmGet$mMessage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mMessageIndex, rowIndex, false);
        }
        String realmGet$mDateTime = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mDateTime();
        if (realmGet$mDateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, realmGet$mDateTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.mStatusIndex, rowIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mStatus(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long tableNativePtr = table.getNativePtr();
        NotificationModelColumnInfo columnInfo = (NotificationModelColumnInfo) realm.getSchema().getColumnInfo(com.khiladiadda.in.network.model.request.NotificationModel.class);
        long pkColumnIndex = columnInfo.mIdIndex;
        com.khiladiadda.in.network.model.request.NotificationModel object = null;
        while (objects.hasNext()) {
            object = (com.khiladiadda.in.network.model.request.NotificationModel) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mId());
            }
            cache.put(object, rowIndex);
            String realmGet$mTitle = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mTitle();
            if (realmGet$mTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mTitleIndex, rowIndex, realmGet$mTitle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mTitleIndex, rowIndex, false);
            }
            String realmGet$mMessage = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mMessage();
            if (realmGet$mMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mMessageIndex, rowIndex, realmGet$mMessage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mMessageIndex, rowIndex, false);
            }
            String realmGet$mDateTime = ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mDateTime();
            if (realmGet$mDateTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, realmGet$mDateTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mDateTimeIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.mStatusIndex, rowIndex, ((com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) object).realmGet$mStatus(), false);
        }
    }

    public static com.khiladiadda.in.network.model.request.NotificationModel createDetachedCopy(com.khiladiadda.in.network.model.request.NotificationModel realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.khiladiadda.in.network.model.request.NotificationModel unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.khiladiadda.in.network.model.request.NotificationModel();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.khiladiadda.in.network.model.request.NotificationModel) cachedObject.object;
            }
            unmanagedObject = (com.khiladiadda.in.network.model.request.NotificationModel) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface unmanagedCopy = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) unmanagedObject;
        com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface realmSource = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$mId(realmSource.realmGet$mId());
        unmanagedCopy.realmSet$mTitle(realmSource.realmGet$mTitle());
        unmanagedCopy.realmSet$mMessage(realmSource.realmGet$mMessage());
        unmanagedCopy.realmSet$mDateTime(realmSource.realmGet$mDateTime());
        unmanagedCopy.realmSet$mStatus(realmSource.realmGet$mStatus());

        return unmanagedObject;
    }

    static com.khiladiadda.in.network.model.request.NotificationModel update(Realm realm, NotificationModelColumnInfo columnInfo, com.khiladiadda.in.network.model.request.NotificationModel realmObject, com.khiladiadda.in.network.model.request.NotificationModel newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface realmObjectTarget = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) realmObject;
        com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface realmObjectSource = (com_khiladiadda_in_network_model_request_NotificationModelRealmProxyInterface) newObject;
        Table table = realm.getTable(com.khiladiadda.in.network.model.request.NotificationModel.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.mIdIndex, realmObjectSource.realmGet$mId());
        builder.addString(columnInfo.mTitleIndex, realmObjectSource.realmGet$mTitle());
        builder.addString(columnInfo.mMessageIndex, realmObjectSource.realmGet$mMessage());
        builder.addString(columnInfo.mDateTimeIndex, realmObjectSource.realmGet$mDateTime());
        builder.addInteger(columnInfo.mStatusIndex, realmObjectSource.realmGet$mStatus());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("NotificationModel = proxy[");
        stringBuilder.append("{mId:");
        stringBuilder.append(realmGet$mId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mTitle:");
        stringBuilder.append(realmGet$mTitle() != null ? realmGet$mTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mMessage:");
        stringBuilder.append(realmGet$mMessage() != null ? realmGet$mMessage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mDateTime:");
        stringBuilder.append(realmGet$mDateTime() != null ? realmGet$mDateTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mStatus:");
        stringBuilder.append(realmGet$mStatus());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
