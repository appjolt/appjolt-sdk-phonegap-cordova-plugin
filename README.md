# AppJolt Cordova/PhoneGap Plugin for Android

For more information about AppJolt, [see www.appjolt.com](http://www.appjolt.com).

## 0. Index

1. [Description](#1-description)
2. [Installation](#2-installation)
3. [Usage](#3-usage)
    3. [End User License Agreement (EULA)](#3a-end-user-license-agreement-eula)
    3. [Custom EULA(Advanced, Optional)](#3b-custom-eula-advanced-optioanal)
    3. [Identifying Users For Analytics Partners (Optional)](#3c-identifying-users-for-analytics-partners-optionals)
    3. [User Segments (Optional)](#3d-user-segments-optional)
    3. [Incognito (Advanced, Optional)](#3e-incognito-advanced-optional) 
4. [License](#4-license)

## 1. Description
This plugin allows you to use AppJolt from your PhoneGap/Cordova app. Works with Android 4.0.3 and higher.

## 2. Installation
First, it is recommended to backup your project.

To install the plugin automatically with PhoneGap, use:
```
$ phonegap local plugin add https://github.com/appjolt/appjolt-sdk-phonegap-cordova-plugin.git
```
To install the plugin automatically with Cordova, use:
```
$ cordova plugin add https://github.com/appjolt/appjolt-sdk-phonegap-cordova-plugin.git
```
Then run:
```
$ cordova prepare
```

## 3. Usage
AppJolt is automatically added to your javascript through the window.plugins.appjolt object. So you are now ready to integrate AppJolt into your Cordova/PhoneGap app:

### 3a. End User License Agreement (EULA)
We find great importance being in compliance with [Google Play Developer Program Policies.](https://play.google.com/about/developer-content-policy.html)
If you are operating within Google's Play store and interacting with ads out of your application, it requires the user's consent in a form of an EULA.
In the context of our service, if you're using Monetize or Ad-Based Winback/Cross-Promotion campaigns, please add the following code to your main menu or splash screen:
```
window.plugins.appjoltcordova.isGooglePlayInstall(function(isGooglePlayInstall) 
    if (isGooglePlayInstall) {
        window.plugins.appjoltcordova.showEULA();
    }
});
```

### 3b. Custom EULA (Advanced, Optional)
While Appjolt comes with a standard EULA that’s displayed to users, you might want to display a different EULA to your users. In order for Appjolt to support a custom EULA, you must notify it as soon as your game initializes that the EULA is handled by the developer. To do so, add the following code when your game starts:
```
window.plugins.appjoltcordova.useCustomEULA();
```
You must then display your custom EULA to the user yourself as soon as possible, then, after it is displayed & accepted, let Appjolt know so using the following code:
```
window.plugins.appjoltcordova.userAcceptedCustomEULA();
```
### 3c. Identifying Users for Analytics Partners (Optional)
If you wish to connect your existing user base to your analytics partner (mixpanel, Cooladata, omniata, etc.), you will have to identify the user/session for that partner using the setIdentify(id) method. For example:
```
// TODO: Sample userId, replace with actual
var userId = "user_id";
// Mixpanel Example - Setting User Id
mixpanel.identify(userId);
// Appjolt UserId identifying
// The userId should be the same as the analytics partner you wish to integrate
window.plugins.appjoltcordova.identify(userId)
```

### 3d. User Segments (Optional)
A User Segment allows you to target specific users that will uninstall your app. For example, create a custom message for your most active users that uninstall or create a custom message for a specific source of media that your users were acquired from. Examples: Dormant, Active, Whales, Purchased, Facebook, Incentivized, etc.
using the methods below.
You can associate a user with one or multiple user segments using the methods below:
```
// Add a new user segment 
window.plugins.appjoltcordova.addUserSegment(userSegment);
// Remove an existing user segment
window.plugins.appjoltcordova.removeUserSegment(userSegment);
// Update user segment
window.plugins.appjoltcordova.updateUserSegment(userSegment);`
// Clear all existing user segments 
window.plugins.appjoltcordva.clearUserSegment();
```

### 3e. Incognito (Advanced, Optional)
Some apps will prefer to disable the collection of user data by Appjolt. Appjolt supports this behaviour by enabling a feature called Incognito, which will stop Appjolt from collecting user data. To enable the incognito feature, add the following code to your project:
```
window.plugins.appjoltcordova.setIncognito(true);
```
You can also disable incognito by passing false to the setIncognito function.

## 4. License
[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.


