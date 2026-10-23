# 📱 Experiment 10 – Implement Data Sharing Using Contact Content Provider

## Develop an Android Application Using the Contact Content Provider

---

## 👨‍💻 Author

**Name:** Manikandan P  
**USN:** 25MCAR0186  
**Subject:** Mobile Application Development Lab

---

## 📖 Experiment Description

This experiment demonstrates data sharing in Android using the **Contact Content Provider** with Kotlin and XML.

The application provides an attractive interface for accessing contacts stored on the Android device. It uses Android's `ContentResolver` to retrieve contact information through `ContactsContract`.

The application displays the available contacts and allows users to **select a particular contact to view its details**, such as the contact name and phone number.

Runtime permission is requested before accessing the device's contacts, ensuring that contact information is accessed only after the user grants permission.

### Scenario

The application simulates a **Contact Directory and Contact Details Viewer**.

```text
             Contact Directory App
                       ↓
                 Display Home Page
                       ↓
              Request Contact Permission
                       ↓
             Permission Granted?
                 ↙           ↘
               Yes            No
                ↓              ↓
         Load Device       Show Permission
           Contacts          Message
                ↓
         Display Contact List
                ↓
        Select a Particular Contact
                ↓
        Display Contact Details
                ↓
       Show Name and Phone Number
```

---

## 🧠 Concept / Technology Used

### Android Contact Content Provider

The Android Contact Content Provider allows applications to access contact information stored on a device through a standard interface. Applications use `ContentResolver` to query the provider and retrieve contact data.

This application uses the following concepts:

* **Content Provider** – Provides a standard way to access shared contact data.
* **ContentResolver** – Queries the Contacts Provider to retrieve contact information.
* **ContactsContract** – Defines the content URIs and column names used to access contacts.
* **Runtime Permissions** – Requests permission to read contacts at runtime.
* **Contact Selection** – Allows users to select a particular contact from the list.
* **Contact Details** – Displays the selected contact's name and phone number.
* **Cursor** – Reads the records returned by a content provider query.
* **Kotlin** – Handles contact retrieval, permission requests, and click events.
* **XML** – Defines the application layout and user interface.
* **Android Studio** – Used for application development, execution, and testing.

---

## 🚀 Features

* 📱 Attractive contact directory interface
* 🎨 Modern gradient background and custom card design
* 🔐 Runtime permission handling for contact access
* 📇 Retrieves contacts stored on the Android device
* 👤 Displays contact names
* 📞 Displays contact phone numbers
* 👆 Allows users to select a particular contact
* 🔍 Displays details of the selected contact
* 📊 Displays the number of retrieved phone entries
* ⚠️ Handles permission denial and empty contact lists
* 🔄 Loads contacts using Android's ContentResolver
* 📱 Scrollable interface for convenient viewing
* 🎓 Displays student name and USN in the footer

---

# 📂 Project Structure

```text
app/
│
├── manifests/
│   └── AndroidManifest.xml
│
├── java/
│   └── com/
│       └── example/
│           └── exp10/
│               └── MainActivity.kt
│
├── res/
│   │
│   ├── drawable/
│   │   ├── bg_gradient.xml
│   │   ├── bg_card.xml
│   │   └── bg_button.xml
│   │
│   ├── layout/
│   │   └── activity_main.xml
│   │
│   └── values/
│       ├── colors.xml
│       ├── strings.xml
│       └── themes.xml
│
└── Gradle Scripts
```

> **Note:** Update the package path and resource files in this structure if your actual project uses different names.

---

# 🎨 User Interface

The application contains the following interface elements:

* Application heading and description
* Contact directory card
* Load Contacts button
* Contact count display
* List of available contacts
* Contact selection interaction
* Selected contact details display
* Permission-denied and no-contacts messages
* Purple-blue gradient background
* Rounded cards and custom buttons
* Footer displaying student name and USN

---

# 🔑 Permission Used

The application requires the following permission in `AndroidManifest.xml`:

```xml
<uses-permission
    android:name="android.permission.READ_CONTACTS" />
```

The permission must be declared in the manifest and requested at runtime before reading contacts on supported Android versions.

---

# 🧪 Test Cases

## Test Case 1 – Application Launch and Contact Permission

### Objective

To verify that the application launches successfully and requests permission to access device contacts.

### Input

1. Launch the Experiment 10 application.
2. Tap the **Load My Contacts** button.
3. Grant contact permission when prompted.

### Expected Result

The application should launch successfully and request permission before accessing contacts. After permission is granted, it should load the available contacts.

### Actual Result

The application launches and requests permission to access contacts. The contact list is displayed after permission is granted.

### Status

✅ **Passed** *(confirm after testing)*

### Screenshot – Application Output

<!-- Add your application home screen screenshot here -->

---

## 🧪 Test Case 2 – Display Contact List

### Objective

To verify that the application retrieves and displays contacts using the Contact Content Provider.

### Input

1. Open the application.
2. Grant contact permission if requested.
3. Tap **Load My Contacts**.

### Expected Result

The application should display the available contact names and phone numbers retrieved from the device's Contacts Provider.

### Actual Result

The application retrieves and displays the available contact entries successfully.

### Status

✅ **Passed** *(confirm after testing)*

### Screenshot – Contact List

<!-- Add your contact list screenshot here -->

---

## 🧪 Test Case 3 – Select a Contact and View Details

### Objective

To verify that selecting a particular contact displays its individual details.

### Input

1. Load the contact list.
2. Select a particular contact.
3. View the displayed contact details.

### Expected Result

The application should identify the selected contact and display its details, including the contact name and phone number.

### Actual Result

The selected contact's details are displayed successfully.

### Status

✅ **Passed** *(confirm after testing)*

### Screenshot – Selected Contact Details

<!-- Add your selected contact details screenshot here -->

---

# 📚 Learning Outcomes

After completing this experiment, the following concepts were understood:

* Understanding Android Content Providers.
* Accessing shared data through `ContentResolver`.
* Retrieving contacts using `ContactsContract`.
* Implementing runtime permission handling.
* Reading query results using a Cursor.
* Displaying contact information in an Android interface.
* Handling user interaction to select and view individual contact details.
* Understanding data sharing between Android applications through a standard provider.

---

# ✅ Conclusion

Thus, an Android application was developed using Kotlin and XML to implement data sharing through the Contact Content Provider. The application retrieves and displays contacts stored on the device, handles runtime permission requests, and allows users to select a particular contact to view its details. The experiment demonstrates how Android applications access shared contact data using `ContentResolver` and `ContactsContract`.
