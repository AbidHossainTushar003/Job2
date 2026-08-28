# Fix Warnings, Errors, and UI Bugs

This plan addresses several warnings related to deprecations, hardcoded strings, and inefficient code patterns, as well as fixing minor UI bugs.

## User Review Required

> [!NOTE]
> I will be migrating `ProfileAdapter` to use `ListAdapter` with `DiffUtil` for better performance.
> I will also add strings to `strings.xml` to avoid hardcoded string warnings.

## Proposed Changes

### Strings and Resources

#### [MODIFY] [strings.xml](file:///H:/Job2/app/src/main/res/values/strings.xml)
- Add strings for "Total Profiles", "Update Profile", "Save Profile", and toast messages.

---

### Data Models and Database

#### [MODIFY] [UserProfile.kt](file:///H:/Job2/app/src/main/java/com/example/job2/data/model/UserProfile.kt)
- Add missing trailing commas.

#### [MODIFY] [ProfileDao.kt](file:///H:/Job2/app/src/main/java/com/example/job2/data/local/ProfileDao.kt)
- Add missing trailing commas.

#### [MODIFY] [ProfileDatabase.kt](file:///H:/Job2/app/src/main/java/com/example/job2/data/local/ProfileDatabase.kt)
- Add missing trailing commas.

---

### UI and Adapters

#### [MODIFY] [ProfileAdapter.kt](file:///H:/Job2/app/src/main/java/com/example/job2/adapter/ProfileAdapter.kt)
- Refactor to extend `ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>`.
- Implement `DiffUtil.ItemCallback`.
- Add missing trailing commas.

#### [MODIFY] [ProfileListActivity.kt](file:///H:/Job2/app/src/main/java/com/example/job2/ui/ProfileListActivity.kt)
- Use resource strings for UI text.
- Move lambda argument out of parentheses.
- Add missing trailing commas.

#### [MODIFY] [AddProfileActivity.kt](file:///H:/Job2/app/src/main/java/com/example/job2/ui/AddProfileActivity.kt)
- Use `Bundle.getSerializable(String, Class)` for API 33+ or a compatibility helper.
- Use resource strings for UI text and toast messages.
- Add missing trailing commas.

#### [MODIFY] [SingleProfileActivity.kt](file:///H:/Job2/app/src/main/java/com/example/job2/ui/SingleProfileActivity.kt)
- Use `Bundle.getSerializable(String, Class)` for API 33+ or a compatibility helper.
- Add missing trailing commas.

#### [MODIFY] [WelcomeActivity.kt](file:///H:/Job2/app/src/main/java/com/example/job2/ui/WelcomeActivity.kt)
- Add missing trailing commas.

---

### ViewModels and Repositories

#### [MODIFY] [ProfileViewModel.kt](file:///H:/Job2/app/src/main/java/com/example/job2/viewmodel/ProfileViewModel.kt)
- Add missing trailing commas.
- (Optional) Remove unused `searchProfiles` if it's really not needed.

#### [MODIFY] [ProfileViewModelFactory.kt](file:///H:/Job2/app/src/main/java/com/example/job2/viewmodel/ProfileViewModelFactory.kt)
- Fix unchecked cast warning.
- Add missing trailing commas.

#### [MODIFY] [ProfileRepository.kt](file:///H:/Job2/app/src/main/java/com/example/job2/data/repository/ProfileRepository.kt)
- Add missing trailing commas.

## Verification Plan

### Automated Tests
- Build the project to ensure all changes compile correctly.
- Run the app to verify list updates, profile addition/editing/deletion.

### Manual Verification
- Check if the "Total Profiles" text updates correctly.
- Verify that clicking on a profile opens the detail view correctly.
- Verify that edit and delete actions work as expected.
