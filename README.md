## Shared Preferences

If you have a relatively small collection of key-values that you'd like to save, you should use the SharedPreferences APIs. A SharedPreferences object points to a file containing key-value pairs and provides simple methods to read and write them. Each SharedPreferences file is managed by the framework and can be private or shared.

Definition Shared Preferences:
```kotlin
lateinit var sharedPreferences : SharedPreferences
```
Initialize Shared Preferences:
```kotlin
sharedPreferences = this.getSharedPreferences("com.omercankoc.sharedpreferences",Context.MODE_PRIVATE)
```
Get operation in Shared Preferences:
```kotlin
// Parameters:(Key,DefaultValue)
name = sharedPreferences.getString("name","")
```
Put operation in Shared Preferences:
```kotlin
// Parameters:(Key,Value)
sharedPreferences!!.edit().putString("username",username).apply()
```
The difference between apply() and commit():
commit(), writes the data synchronously (blocking the thread its called from). It then informs you about the success of the operation.
apply(), schedules the data to be written asynchronously. It does not inform you about the success of the operation.

Remove operation in Shared Preferences:
```kotlin
// Parameters:(Key)
sharedPreferences.edit().remove("username").apply()
```
