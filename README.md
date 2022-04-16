# TMDBClient
My First MVVM Clean Architecture Project With The <a href="https://www.themoviedb.org/documentation/api">Movie Database API</a>

## Android Architecture
Android Architecture는 확장에 용이하고 쉽게 유지보수 할 수 있도록 Android Project의 구조를 설계하는 것 입니다. 
개발자들은 프로젝트를 build 하는 것 보다 maintaining 유지하는데 더 많은 시간을 써야합니다. 
그래서 적절한 Architecture Pattern을 사용하는 것이 중요합니다. 

## Android MVVM Pattern
*MVVM ( stand for Model-View-ViewModel)*
<a href="https://www.journaldev.com/20292/android-mvvm-design-pattern"><img src="https://www.journaldev.com/wp-content/uploads/2018/04/android-mvvm-pattern.png.webp"/></a>
* **Model** : Model은 앱의 데이터들을 갖습니다. Model은 직접적으로 View와 통신할 수 없습니다. 일반적으로 데이터를 ViewModel의 Observables를 통해서 나타내는 것이 권장됩니다. 

* **View** : View는 어떠한 앱의 로직도 없는 응용프로그램의 UI를 나타냅니다. View는 ViewModel을 Observes합니다. 

* **ViewModel** : ViewModel은 View와 Model의 연결고리 같은 역할을 합니다. ViewModel은 책임지고 Model에서부터 나오는 데이터 스트림을 View에게 제공합니다. 또 hook 또는 callback을 이용하여 View를 업데이트합니다. 그리고 Model에게 데이터를 요청합니다.


### MVC vs MVVM in Android
안드로이드에서 MCV는 default pattern으로 여겨집니다. Activity들은 Controller로 여겨지고, View는 Xml파일들 입니다.<br>
MVVM은 Activity와 XML 파일 둘 다 View로 여깁니다. 그리고 ViewModel 클래스에는 business logic을 작성합니다.<br>
이것은 완전하게 앱의 UI와 Logic을 분리시킵니다. <br>

### MVP vs MVVM in Android 
MVP에서는 Presenter와 View가 서를 알 수 있습니다. 둘은 서로의 interface를 통해 상호작용 합니다. <br>
MVVM에서는 ViewModel은 View를 알 수 없고, 오직 View만 ViewModel을 알 수 있습니다. <br>
Presenter는 method를 trigger 시켜서 View를 업데이트하지만, ViewModel에서는 data Steam으로 데이터를 전송합니다. <br>
Presenter와 View는 1:1 관계이지만, View와 ViewModel은 1:多관계입니다. <br>

**Two Way to imeplement MVVM in Adroid**
* Data Binding
* RxJava

## <a href="https://whatis.techtarget.com/definition/clean-architecture">Clean Architecure</a>
클린 아키텍쳐는 소프트웨어 설계 철학 중 하나로, ring level로 설계 요소들로 나누는 방식 입니다. <br>
클린 아키텍쳐의 중요한 목표는 개발자들에게 business logic을 캡슐화 시키면서 delivery mecahnism에서 분리시도록 코드를 체계화 시켜 제공하는 것입니다. <img src="https://cdn.ttgtmedia.com/rms/onlineImages/app_arch-layers_clean_architecture-f_desktop.png"><br>
클린아키텍쳐는 높은 레벨의 추상화와 잘 정의된 연관성으로 각기 다른 계층에서 코드를 분리시켜서 느슨하게 결합이 되는것을 허용합니다.<br>
그래서 읽기 쉬운 코드와 수정 그리고 테스트를 원할하게 진행할 수 있게 합니다. <br>

클린 아키텍쳐의 중요 규칙은 code dependencies가 밖에서부터 안으로만 움직이는 것입니다. <br>
내부 Layer의 코드들은 밖에서 정의된 코드들을 알 수 없고, 외부에서 정의된 변수, 함수와 클래스들은 내부에서 언급될 수 없습니다. <br>
또한, 데이터 포맷들이 수준별로 분리되는 것이 권장됩니다. <br>

클린 아키텍쳐 안에서는 public interface를 통해서 모든 통신들이 진행되어 Enterprise level의 큰 프로젝트는 팀 협업에도 아주 적합합니다.<br>

클린 아키텍쳐는 3개의 계층으로 나눌 수 있습니다.
![3layers](https://user-images.githubusercontent.com/55622345/158380160-115f8ecb-a1dc-4ad5-b12d-7e613cb82a2c.PNG)<br>
Presentation(Application) Layer - 
이 계층은 사용자와 상호작용하는 계층으로, 화면에 여려가지를 띄우며 Listener를 통해 사용자의 입력을 받습니다. <br>
안드로이드에서는 Activiy, Fragment, ViewModel, Adapter 그리고 Dependency Injection들의 Class와 Interface를 포함합니다. <br>
클린 아키텍쳐에서 ViewModel은 Repository Class와 직접적으로 상호작용해서는 안되며, ViewModel은 UseCase를 통해서 Repository에 상호작용하게 됩니다. <br>

Domain Layer - 
앱의 비즈니스 로직을 포함합니다. 특정 작업을 수행하는 UseCase class를 포함 할 수 있고, Repository interface와 Entity class를 포함시킬 수 있습니다. <br>
만약 Entity class가 안드로이드의 특정한 의존성을 갖는다면 Data Layer에 추가해야합니다. <br>

Data Layer - 
데이터 계층은 모든 Data Source(여기선 Cache, Local_ROOM, API)의 추상적 정의와 인터페이스들을 포함합니다. <br>
주로 Repostiroy의 interface를 domain layer에 정의했다면, Implementation class들은 data layer에 정의합니다. <br>

## Preview
*추가 예정*

## Architecture
*추가 예정*

### Ref.
* **<a href="https://www.journaldev.com/20292/android-mvvm-design-pattern">MVVM을 이용한 예1</a>**
* **<a href="https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture">MVVM with Clean Architecture 예</a>**
* **<a href="https://github.com/android10/Android-CleanArchitecture-Kotlin">이 프로젝트와 유사한 프로젝트<a>**
