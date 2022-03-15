# TMDBClient
MVVM Clean Architecture Project With The <a href="https://www.themoviedb.org/documentation/api">Movie Database API</a>


## <a href="https://whatis.techtarget.com/definition/clean-architecture">Clean Architecure</a>
클린 아키텍쳐는 소프트웨어 설계 철학 중 하나로, ring level로 설계 요소들로 나누는 방식 입니다. 
클린 아키텍쳐의 중요한 목표는 개발자들에게 business logic을 캡슐화 시키면서 delivery mecahnism에서 분리시도록 코드를 체계화 시켜 제공하는 것입니다. 
<img src="https://cdn.ttgtmedia.com/rms/onlineImages/app_arch-layers_clean_architecture-f_desktop.png">
클린아키텍쳐는 높은 레벨의 추상화와 잘 정의된 연관성으로 각기 다른 계층에서 코드를 분리시켜서 느슨하게 결합이 되는것을 허용합니다.
그래서 읽기 쉬운 코드와 수정 그리고 테스트를 원할하게 진행할 수 있게 합니다. 

클린 아키텍쳐의 중요 규칙은 code dependencies가 밖에서부터 안으로만 움직이는 것입니다. 
내부 Layer의 코드들은 밖에서 정의된 코드들을 알 수 없고, 외부에서 정의된 변수, 함수와 클래스들은 내부에서 언급될 수 없습니다. 
또한, 데이터 포맷들이 수준별로 분리되는 것이 권장됩니다. 

클린 아키텍쳐 안에서는 public interface를 통해서 모든 통신들이 진행되어 Enterprise level의 큰 프로젝트는 팀 협업에도 아주 적합합니다.

클린 아키텍쳐는 3개의 계층으로 나눌 수 있습니다. 
![3layers](https://user-images.githubusercontent.com/55622345/158380160-115f8ecb-a1dc-4ad5-b12d-7e613cb82a2c.PNG)
Presentation(application) Layer - 
이 계층은 사용자와 상호작용하는 계층으로, 화면에 여려가지를 띄우며 Listener를 통해 사용자의 입력을 받습니다. 
안드로이드에서는 Activiy, Fragment, ViewModel, Adapter 그리고 Dependency Injection들의 Class와 Interface를 포함합니다. 
클린 아키텍쳐에서 ViewModel은 Repository Class와 직접적으로 상호작용해서는 안되며, ViewModel은 UseCase를 통해서 Repository에 상호작용하게 됩니다. 
