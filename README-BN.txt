Voter List 2027 Android project

এই প্রকল্পে Excel ফাইলের ৯৫৩টি ডেটা রেকর্ড offline ব্যবহারের জন্য voters.json-এ রাখা হয়েছে।
ফিচার: নাম/ঠিকানা/মোবাইল সার্চ, রেকর্ড দেখা, মোট রেকর্ড গণনা, CSV Export।
কোনো ইন্টারনেট বা সার্ভার প্রয়োজন নেই।

গুরুত্বপূর্ণ ডেটা নোট:
মূল Excel-এর বাংলা লেখা Bijoy/ANSI legacy encoding-এ সংরক্ষিত বলে মনে হচ্ছে।
তাই অ্যাপে মূল সেলের লেখা হুবহু রাখা হয়েছে; কিছু ডিভাইসে বাংলা অক্ষর সঠিকভাবে না-ও দেখা যেতে পারে।
Unicode-এ রূপান্তরের পর আরও ভালো বাংলা প্রদর্শন সম্ভব।

APK তৈরি:
1. Android Studio ইনস্টল করুন।
2. এই ZIP extract করে Android Studio-তে VoterList2027 ফোল্ডার Open করুন।
3. Gradle sync শেষ হলে Build > Build Bundle(s) / APK(s) > Build APK(s) চাপুন।
4. APK পাওয়া যাবে: app/build/outputs/apk/debug/app-debug.apk

ডেটা গোপনীয়তা:
ডেটা অ্যাপের assets-এ স্থানীয়ভাবে থাকে। অ্যাপ কোনো সার্ভারে ডেটা পাঠায় না।
