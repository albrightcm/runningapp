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
public class ude_esom_runningapp_PastRunRealmProxy extends ude.esom.runningapp.PastRun
    implements RealmObjectProxy, ude_esom_runningapp_PastRunRealmProxyInterface {

    static final class PastRunColumnInfo extends ColumnInfo {
        long idColKey;
        long datePerformedColKey;
        long distanceTraveledColKey;
        long averageSpeedColKey;
        long minSpeedColKey;
        long maxSpeedColKey;
        long secondsColKey;
        long caloriesBurnedColKey;

        PastRunColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PastRun");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.datePerformedColKey = addColumnDetails("datePerformed", "datePerformed", objectSchemaInfo);
            this.distanceTraveledColKey = addColumnDetails("distanceTraveled", "distanceTraveled", objectSchemaInfo);
            this.averageSpeedColKey = addColumnDetails("averageSpeed", "averageSpeed", objectSchemaInfo);
            this.minSpeedColKey = addColumnDetails("minSpeed", "minSpeed", objectSchemaInfo);
            this.maxSpeedColKey = addColumnDetails("maxSpeed", "maxSpeed", objectSchemaInfo);
            this.secondsColKey = addColumnDetails("seconds", "seconds", objectSchemaInfo);
            this.caloriesBurnedColKey = addColumnDetails("caloriesBurned", "caloriesBurned", objectSchemaInfo);
        }

        PastRunColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PastRunColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PastRunColumnInfo src = (PastRunColumnInfo) rawSrc;
            final PastRunColumnInfo dst = (PastRunColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.datePerformedColKey = src.datePerformedColKey;
            dst.distanceTraveledColKey = src.distanceTraveledColKey;
            dst.averageSpeedColKey = src.averageSpeedColKey;
            dst.minSpeedColKey = src.minSpeedColKey;
            dst.maxSpeedColKey = src.maxSpeedColKey;
            dst.secondsColKey = src.secondsColKey;
            dst.caloriesBurnedColKey = src.caloriesBurnedColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PastRunColumnInfo columnInfo;
    private ProxyState<ude.esom.runningapp.PastRun> proxyState;

    ude_esom_runningapp_PastRunRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PastRunColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<ude.esom.runningapp.PastRun>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idColKey);
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
    public Date realmGet$datePerformed() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.datePerformedColKey);
    }

    @Override
    public void realmSet$datePerformed(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'datePerformed' to null.");
            }
            row.getTable().setDate(columnInfo.datePerformedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'datePerformed' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.datePerformedColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$distanceTraveled() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.distanceTraveledColKey);
    }

    @Override
    public void realmSet$distanceTraveled(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.distanceTraveledColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.distanceTraveledColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$averageSpeed() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.averageSpeedColKey);
    }

    @Override
    public void realmSet$averageSpeed(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.averageSpeedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.averageSpeedColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$minSpeed() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.minSpeedColKey);
    }

    @Override
    public void realmSet$minSpeed(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.minSpeedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.minSpeedColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$maxSpeed() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.maxSpeedColKey);
    }

    @Override
    public void realmSet$maxSpeed(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.maxSpeedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.maxSpeedColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$seconds() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.secondsColKey);
    }

    @Override
    public void realmSet$seconds(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.secondsColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.secondsColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$caloriesBurned() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.caloriesBurnedColKey);
    }

    @Override
    public void realmSet$caloriesBurned(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.caloriesBurnedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.caloriesBurnedColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "PastRun", false, 8, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "datePerformed", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "distanceTraveled", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "averageSpeed", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "minSpeed", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "maxSpeed", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "seconds", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "caloriesBurned", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PastRunColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PastRunColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PastRun";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PastRun";
    }

    @SuppressWarnings("cast")
    public static ude.esom.runningapp.PastRun createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        ude.esom.runningapp.PastRun obj = null;
        if (update) {
            Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
            PastRunColumnInfo columnInfo = (PastRunColumnInfo) realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("id")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ude_esom_runningapp_PastRunRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ude_esom_runningapp_PastRunRealmProxy) realm.createObjectInternal(ude.esom.runningapp.PastRun.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ude_esom_runningapp_PastRunRealmProxy) realm.createObjectInternal(ude.esom.runningapp.PastRun.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final ude_esom_runningapp_PastRunRealmProxyInterface objProxy = (ude_esom_runningapp_PastRunRealmProxyInterface) obj;
        if (json.has("datePerformed")) {
            if (json.isNull("datePerformed")) {
                objProxy.realmSet$datePerformed(null);
            } else {
                Object timestamp = json.get("datePerformed");
                if (timestamp instanceof String) {
                    objProxy.realmSet$datePerformed(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$datePerformed(new Date(json.getLong("datePerformed")));
                }
            }
        }
        if (json.has("distanceTraveled")) {
            if (json.isNull("distanceTraveled")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'distanceTraveled' to null.");
            } else {
                objProxy.realmSet$distanceTraveled((double) json.getDouble("distanceTraveled"));
            }
        }
        if (json.has("averageSpeed")) {
            if (json.isNull("averageSpeed")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'averageSpeed' to null.");
            } else {
                objProxy.realmSet$averageSpeed((double) json.getDouble("averageSpeed"));
            }
        }
        if (json.has("minSpeed")) {
            if (json.isNull("minSpeed")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minSpeed' to null.");
            } else {
                objProxy.realmSet$minSpeed((double) json.getDouble("minSpeed"));
            }
        }
        if (json.has("maxSpeed")) {
            if (json.isNull("maxSpeed")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxSpeed' to null.");
            } else {
                objProxy.realmSet$maxSpeed((double) json.getDouble("maxSpeed"));
            }
        }
        if (json.has("seconds")) {
            if (json.isNull("seconds")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'seconds' to null.");
            } else {
                objProxy.realmSet$seconds((int) json.getInt("seconds"));
            }
        }
        if (json.has("caloriesBurned")) {
            if (json.isNull("caloriesBurned")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'caloriesBurned' to null.");
            } else {
                objProxy.realmSet$caloriesBurned((int) json.getInt("caloriesBurned"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static ude.esom.runningapp.PastRun createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final ude.esom.runningapp.PastRun obj = new ude.esom.runningapp.PastRun();
        final ude_esom_runningapp_PastRunRealmProxyInterface objProxy = (ude_esom_runningapp_PastRunRealmProxyInterface) obj;
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
            } else if (name.equals("datePerformed")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$datePerformed(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$datePerformed(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$datePerformed(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("distanceTraveled")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$distanceTraveled((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'distanceTraveled' to null.");
                }
            } else if (name.equals("averageSpeed")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$averageSpeed((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'averageSpeed' to null.");
                }
            } else if (name.equals("minSpeed")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$minSpeed((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minSpeed' to null.");
                }
            } else if (name.equals("maxSpeed")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$maxSpeed((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxSpeed' to null.");
                }
            } else if (name.equals("seconds")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$seconds((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'seconds' to null.");
                }
            } else if (name.equals("caloriesBurned")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$caloriesBurned((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'caloriesBurned' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static ude_esom_runningapp_PastRunRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class), false, Collections.<String>emptyList());
        io.realm.ude_esom_runningapp_PastRunRealmProxy obj = new io.realm.ude_esom_runningapp_PastRunRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static ude.esom.runningapp.PastRun copyOrUpdate(Realm realm, PastRunColumnInfo columnInfo, ude.esom.runningapp.PastRun object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
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
            return (ude.esom.runningapp.PastRun) cachedRealmObject;
        }

        ude.esom.runningapp.PastRun realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
            long pkColumnKey = columnInfo.idColKey;
            String value = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$id();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.ude_esom_runningapp_PastRunRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static ude.esom.runningapp.PastRun copy(Realm realm, PastRunColumnInfo columnInfo, ude.esom.runningapp.PastRun newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (ude.esom.runningapp.PastRun) cachedRealmObject;
        }

        ude_esom_runningapp_PastRunRealmProxyInterface unmanagedSource = (ude_esom_runningapp_PastRunRealmProxyInterface) newObject;

        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addDate(columnInfo.datePerformedColKey, unmanagedSource.realmGet$datePerformed());
        builder.addDouble(columnInfo.distanceTraveledColKey, unmanagedSource.realmGet$distanceTraveled());
        builder.addDouble(columnInfo.averageSpeedColKey, unmanagedSource.realmGet$averageSpeed());
        builder.addDouble(columnInfo.minSpeedColKey, unmanagedSource.realmGet$minSpeed());
        builder.addDouble(columnInfo.maxSpeedColKey, unmanagedSource.realmGet$maxSpeed());
        builder.addInteger(columnInfo.secondsColKey, unmanagedSource.realmGet$seconds());
        builder.addInteger(columnInfo.caloriesBurnedColKey, unmanagedSource.realmGet$caloriesBurned());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.ude_esom_runningapp_PastRunRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, ude.esom.runningapp.PastRun object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        long tableNativePtr = table.getNativePtr();
        PastRunColumnInfo columnInfo = (PastRunColumnInfo) realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$id();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        java.util.Date realmGet$datePerformed = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$datePerformed();
        if (realmGet$datePerformed != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePerformedColKey, objKey, realmGet$datePerformed.getTime(), false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.distanceTraveledColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$distanceTraveled(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.averageSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$averageSpeed(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.minSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$minSpeed(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.maxSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$maxSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.secondsColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$seconds(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.caloriesBurnedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$caloriesBurned(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        long tableNativePtr = table.getNativePtr();
        PastRunColumnInfo columnInfo = (PastRunColumnInfo) realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class);
        long pkColumnKey = columnInfo.idColKey;
        ude.esom.runningapp.PastRun object = null;
        while (objects.hasNext()) {
            object = (ude.esom.runningapp.PastRun) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$id();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            java.util.Date realmGet$datePerformed = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$datePerformed();
            if (realmGet$datePerformed != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePerformedColKey, objKey, realmGet$datePerformed.getTime(), false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.distanceTraveledColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$distanceTraveled(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.averageSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$averageSpeed(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.minSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$minSpeed(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.maxSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$maxSpeed(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.secondsColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$seconds(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.caloriesBurnedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$caloriesBurned(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, ude.esom.runningapp.PastRun object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        long tableNativePtr = table.getNativePtr();
        PastRunColumnInfo columnInfo = (PastRunColumnInfo) realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$id();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        java.util.Date realmGet$datePerformed = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$datePerformed();
        if (realmGet$datePerformed != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePerformedColKey, objKey, realmGet$datePerformed.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.datePerformedColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.distanceTraveledColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$distanceTraveled(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.averageSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$averageSpeed(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.minSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$minSpeed(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.maxSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$maxSpeed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.secondsColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$seconds(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.caloriesBurnedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$caloriesBurned(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        long tableNativePtr = table.getNativePtr();
        PastRunColumnInfo columnInfo = (PastRunColumnInfo) realm.getSchema().getColumnInfo(ude.esom.runningapp.PastRun.class);
        long pkColumnKey = columnInfo.idColKey;
        ude.esom.runningapp.PastRun object = null;
        while (objects.hasNext()) {
            object = (ude.esom.runningapp.PastRun) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$id();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            java.util.Date realmGet$datePerformed = ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$datePerformed();
            if (realmGet$datePerformed != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.datePerformedColKey, objKey, realmGet$datePerformed.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.datePerformedColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.distanceTraveledColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$distanceTraveled(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.averageSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$averageSpeed(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.minSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$minSpeed(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.maxSpeedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$maxSpeed(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.secondsColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$seconds(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.caloriesBurnedColKey, objKey, ((ude_esom_runningapp_PastRunRealmProxyInterface) object).realmGet$caloriesBurned(), false);
        }
    }

    public static ude.esom.runningapp.PastRun createDetachedCopy(ude.esom.runningapp.PastRun realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        ude.esom.runningapp.PastRun unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new ude.esom.runningapp.PastRun();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (ude.esom.runningapp.PastRun) cachedObject.object;
            }
            unmanagedObject = (ude.esom.runningapp.PastRun) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ude_esom_runningapp_PastRunRealmProxyInterface unmanagedCopy = (ude_esom_runningapp_PastRunRealmProxyInterface) unmanagedObject;
        ude_esom_runningapp_PastRunRealmProxyInterface realmSource = (ude_esom_runningapp_PastRunRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$datePerformed(realmSource.realmGet$datePerformed());
        unmanagedCopy.realmSet$distanceTraveled(realmSource.realmGet$distanceTraveled());
        unmanagedCopy.realmSet$averageSpeed(realmSource.realmGet$averageSpeed());
        unmanagedCopy.realmSet$minSpeed(realmSource.realmGet$minSpeed());
        unmanagedCopy.realmSet$maxSpeed(realmSource.realmGet$maxSpeed());
        unmanagedCopy.realmSet$seconds(realmSource.realmGet$seconds());
        unmanagedCopy.realmSet$caloriesBurned(realmSource.realmGet$caloriesBurned());

        return unmanagedObject;
    }

    static ude.esom.runningapp.PastRun update(Realm realm, PastRunColumnInfo columnInfo, ude.esom.runningapp.PastRun realmObject, ude.esom.runningapp.PastRun newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        ude_esom_runningapp_PastRunRealmProxyInterface realmObjectTarget = (ude_esom_runningapp_PastRunRealmProxyInterface) realmObject;
        ude_esom_runningapp_PastRunRealmProxyInterface realmObjectSource = (ude_esom_runningapp_PastRunRealmProxyInterface) newObject;
        Table table = realm.getTable(ude.esom.runningapp.PastRun.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addDate(columnInfo.datePerformedColKey, realmObjectSource.realmGet$datePerformed());
        builder.addDouble(columnInfo.distanceTraveledColKey, realmObjectSource.realmGet$distanceTraveled());
        builder.addDouble(columnInfo.averageSpeedColKey, realmObjectSource.realmGet$averageSpeed());
        builder.addDouble(columnInfo.minSpeedColKey, realmObjectSource.realmGet$minSpeed());
        builder.addDouble(columnInfo.maxSpeedColKey, realmObjectSource.realmGet$maxSpeed());
        builder.addInteger(columnInfo.secondsColKey, realmObjectSource.realmGet$seconds());
        builder.addInteger(columnInfo.caloriesBurnedColKey, realmObjectSource.realmGet$caloriesBurned());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PastRun = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{datePerformed:");
        stringBuilder.append(realmGet$datePerformed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{distanceTraveled:");
        stringBuilder.append(realmGet$distanceTraveled());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{averageSpeed:");
        stringBuilder.append(realmGet$averageSpeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{minSpeed:");
        stringBuilder.append(realmGet$minSpeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxSpeed:");
        stringBuilder.append(realmGet$maxSpeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{seconds:");
        stringBuilder.append(realmGet$seconds());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{caloriesBurned:");
        stringBuilder.append(realmGet$caloriesBurned());
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
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ude_esom_runningapp_PastRunRealmProxy aPastRun = (ude_esom_runningapp_PastRunRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aPastRun.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPastRun.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aPastRun.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
