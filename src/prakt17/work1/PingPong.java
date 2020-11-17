package prakt17.work1;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.HashMap;

import static java.lang.Math.abs;

public class PingPong extends Application{

    //Хранение нажатых клавиш:
    private HashMap<String,Boolean> currentlyActiveKeys=new HashMap<>();
    //Объект для поиска пути до файла (картинки):
    CurrentWorkingDirectory currentWorkingDirectory=new CurrentWorkingDirectory();
    /////Объекты с анимацией:

    //Красная (левая) ракетка
    TranslateTransition translateTransition_racketRed=new TranslateTransition();
    //Синяя (правая) креветка
    TranslateTransition translateTransition_racketBlue=new TranslateTransition();

    //Мячик :Ъ
    TranslateTransition translateTransition_ball=new TranslateTransition();

    //Эмблема хода Красной (левой) команды
    TranslateTransition translateTransition_playRed=new TranslateTransition();
    //Эмблема хода Синей (правой) команды
    TranslateTransition translateTransition_playBlue=new TranslateTransition();

    //Картинка выигрыша Красной (левой) команды
    TranslateTransition translateTransition_teamRed=new TranslateTransition();
    //Картинка выигрыша (правой) команды
    TranslateTransition translateTransition_teamBlue=new TranslateTransition();

    //////Start for Ball:
    //Условие работы шарика (после установки мышкой вектора движения и до проигрышка одного из участников)
    boolean condition_start_ball=true;
    //Условия полёта- отвечают за направление полёта (по знаку +/-) шарика; Обновляются на противоположное значение
    //при столкновении со стенкой
    // (Например: при столкновении с правой стенкой bool_x_right становится false, а bool_x_left- true;
    // bool_y_up и bool_y_down при данной ситуации не обновляют значения)
    boolean bool_y_up=true;
    boolean bool_y_down=true;
    boolean bool_x_right=true;
    boolean bool_x_left=true;

    //Ball:
    //Границы карты для мячика:
    float x_right=450f;//38/2);
    float x_left=-408f;


    float y_up=-250f;
    float y_down=275f;//-38/2);

    //Шаг мячика, который задаётся мышкой в начале игры
    // (заменяет работу с углом на работу шагом в локальных координатах- углы в игре не используются)
    float x_by=1000;
    float y_by=1000;

    //Условие начала игры:
    boolean play_condition=true;

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        ///////Генерация путей к картинкам
        //Картинка фона (стола с игровым полем)
        Image image_table=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("table.png")));//"D:\\2020\\java-tasks\\src\\prakt17\\work1\\table.png"));
        Image image_racketRed=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("racketRed.png")));
        Image image_racketBlue=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("racketBlue.png")));
        Image image_ball=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("ball.png")));
        //Картинка нового курсора
        Image image_cursor=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("cursor.png")));
        Image image_playRed=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("playRed.png")));
        Image image_playBlue=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("playBlue.png")));
        Image image_teamRed=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("teamRedWins.png")));
        Image image_teamBlue=new Image(new FileInputStream(currentWorkingDirectory.getPathFile("teamBlueWins.png")));

        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_teamRed=new ImageView(image_teamRed);


        //System.out.println(imageView_playRed.getTranslateY());
        //Setting the position of the image
        imageView_teamRed.setX(500-300-1000);
        imageView_teamRed.setY(-((700+210)-700));

        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_teamBlue=new ImageView(image_teamBlue);


        //System.out.println(imageView_playRed.getTranslateY());
        //Setting the position of the image
        imageView_teamBlue.setX(500-145+1000);
        imageView_teamBlue.setY(-((700+210)-300));


        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_playRed=new ImageView(image_playRed);


        //System.out.println(imageView_playRed.getTranslateY());
        //Setting the position of the image
        imageView_playRed.setX(200);
        imageView_playRed.setY(700);

        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_playBlue=new ImageView(image_playBlue);


        //System.out.println(imageView_playRed.getTranslateY());
        //Setting the position of the image
        imageView_playBlue.setX(580);
        imageView_playBlue.setY(700);


        //Setting the image view 1
        ImageView imageView_table=new ImageView(image_table);

        //Setting the position of the image
        imageView_table.setX(0);
        imageView_table.setY(0);

        //setting the fit height and width of the image view
        //imageView1.setFitHeight(300);
        //imageView1.setFitWidth(250);

        //Настройка соотношений картинки сцены
        imageView_table.setPreserveRatio(true);

        //Setting the image view 2
        ImageView imageView_racketRed=new ImageView(image_racketRed);

        //Setting the position of the image
        imageView_racketRed.setX(55-90/2);
        imageView_racketRed.setY(350-200/2);

        //setting the fit height and width of the image view
        //imageView2.setFitHeight(150);
        //imageView2.setFitWidth(250);

        //Настройка соотношений картинки сцены
        imageView_racketRed.setPreserveRatio(true);

        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_racketBlue=new ImageView(image_racketBlue);

        //Setting the position of the image
        imageView_racketBlue.setX(945-90/2);
        imageView_racketBlue.setY(350-200/2);

        //setting the fit height and width of the image view
        //imageView3.setFitHeight(100);
        //imageView3.setFitWidth(100);

        //Настройка соотношений картинки сцены
        imageView_racketBlue.setPreserveRatio(true);

        //Загрузка и установка локальных координат картинок, которые будут в сцене
        ImageView imageView_ball=new ImageView(image_ball);


        //Отладка
                                System.out.println(imageView_ball.getTranslateY());
        //Setting the position of the image
        imageView_ball.setX(500-38/2);
        imageView_ball.setY(350-38/2);

        //System.out.println(imageView_ball.getTranslateY());



        //System.out.println(imageView_ball.getTranslateY());

        //setting the fit height and width of the image view
        //imageView3.setFitHeight(100);
        //imageView3.setFitWidth(100);

        //Настройка соотношений картинки сцены
        imageView_racketBlue.setPreserveRatio(true);


        /////

        ////Установка Node'а для объектов с анимацей по картинкам сцены
        translateTransition_racketBlue.setNode(imageView_racketBlue);
        translateTransition_racketRed.setNode(imageView_racketRed);
        translateTransition_ball.setNode(imageView_ball);

        translateTransition_playRed.setNode(imageView_playRed);
        translateTransition_playBlue.setNode(imageView_playBlue);

        translateTransition_teamRed.setNode(imageView_teamRed);
        translateTransition_teamBlue.setNode(imageView_teamBlue);
        /////


        //Создание root группы объектов, которые будут отображаться в сцене
        Group root=new Group(imageView_table,imageView_racketRed,imageView_racketBlue,imageView_ball,imageView_playRed,imageView_playBlue,imageView_teamRed,imageView_teamBlue);

        //Создание сцены
        Scene scene=new Scene(root,1000,(700+210));

        //Установка объекта курсора сцены с новой картинкой (ракетка с ручкой) и с координатами нажатия
        scene.setCursor(new ImageCursor(image_cursor,
                                        image_cursor.getWidth()/2,
                                        image_cursor.getHeight()/2));
        //Установка заголовка окна
        stage.setTitle("Ping-... PONG!");

        //Внедрение заданной сцены в окно
        stage.setScene(scene);

        //Включение отображения контента сцены в окне
        stage.show();

        /////События сцены.

        //Обработка событий сцены по зажатию клавиши клавиатуры:
        scene.setOnKeyPressed(event->{
            //Перевод названий нажатых и отжатых клавиш в String
            String codeString=event.getCode().toString();
            //Проверка на нажатие (была ли клавиша нажата повтороно- нужно, чтобы не добавлять клавишу несколько раз)
            if(!currentlyActiveKeys.containsKey(codeString)){
                //Добавление нажатой клавиши в список
                currentlyActiveKeys.put(codeString,true);
                //Удаление отжатой клавиши из списка
                currentlyActiveKeys.remove(codeString+"-Released");
            }
        });
        //Обработка событий сцены по отжатию клавиши клавиатуры:
        scene.setOnKeyReleased(event->{
            //Перевод названий нажатых и отжатых клавиш в String
            String getcodeToString=event.getCode().toString();
            //Без проверки на отжатие (была ли клавиша отжата повтороно- нужно, чтобы не добавлять клавишу несколько раз)
            //Проверки нет, т.к. клаваша не может быть отжата, если не была до этого зажата
            //Удаление нажатой клавиши
            currentlyActiveKeys.remove(getcodeToString);
            //Добавление отжатой клавиши
            currentlyActiveKeys.put((getcodeToString+"-Released"),true);
        });

        //Обработка событий сцены по нажатию на клавишу мыши:
        root.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                //Условие начала игры (false, когда один из игроков проиграл)
                if(play_condition==true){
                    //Условие полёта мячика в начале игры
                    // (false, когда мышкой был задан вектор направления полёта шарика)
                    if(condition_start_ball==true){
                        //Установка координаты шага полёта мячика относительно центра игрового поля (точка (0,0))
                        // по координатам курсора мышки
                        x_by=(float)event.getSceneX()-500;
                        y_by=(float)event.getSceneY()-350;
                        //Установка направления вектора, где модуль одной из координат шага
                        // (например, y_by) равен |1000|,
                        // а модуль второй координаты шага
                        // (например, x_by)- x_by*(1000/y_by).
                        //Также происходит установка знака (куда будет лететь шар)
                        if(x_by>y_by){
                            float znak_1000;
                            if(y_by<0){
                                znak_1000=-1000;
                            }else{
                                znak_1000=1000;
                            }
                            float buf_by;
                            buf_by=abs(1000/y_by);
                            y_by=znak_1000;
                            x_by=x_by*buf_by;
                        }else{
                            float znak_1000;
                            if(x_by<0){
                                znak_1000=-1000;
                            }else{
                                znak_1000=1000;
                            }
                            float buf_by;
                            buf_by=abs(1000/x_by);
                            x_by=znak_1000;
                            y_by=y_by*buf_by;
                        }
                        //Отладка
                                System.out.println(x_by);
                        //Отладка
                                System.out.println(y_by);
                        //Анимация первого полёта шарика (всегда на шаг x_by и y_by)
                        translateTransition_ball.setByX(x_by);
                        translateTransition_ball.setByY(y_by);
                        //Установка скорости анимации перемещения шарика
                        translateTransition_ball.setRate(0.2);//(Math.pow(10,Math.pow(10,abs(((float)event.getSceneX()-510)/185))/50))/1000000);;//0.2);
                        //Установка auto reverse value на false
                        translateTransition_ball.setAutoReverse(false);
                        //Начало работы анимации
                        translateTransition_ball.play();
                        //Условие начальной настройки шарика завершено
                        // (теперь нажатие клавиши мышки будет игнорироваться )
                        condition_start_ball=false;


                        //Анимация  выхода за карту эмблем красной и синей команд
                        translateTransition_playRed.setToX(-500);
                        //////Setting auto reverse value to false
                        translateTransition_ball.setAutoReverse(false);
                        translateTransition_playRed.play();
                        translateTransition_playBlue.setToX(500);
                        //////Setting auto reverse value to false
                        translateTransition_ball.setAutoReverse(false);
                        translateTransition_playBlue.play();

                    }
                }
            }
        });
        //Таймер анимации
        // (за каждый шаг таймера происходит анимация любого объекта и выполняются заданные условия)
        new AnimationTimer(){
            @Override
            public void handle(long now){

                //Условие игры
                // (true, пока никто не проиграл)
                if(play_condition==true){
                    //System.out.println(translateTransition_ball.getStatus());
                    //if(translateTransition_ball.getStatus() != Animation.Status.RUNNING) {
                    //         System.out.println(imageView_ball.getTranslateY());
                    //}
                    //System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
                    //System.out.println(MouseInfo.getPointerInfo().getLocation().getY());
                    //System.out.println(imageView_ball.getTranslateY());

                    //Условие начала полёта шарика
                    // (false, когда мышкой задан вектор направления полёта шарика)
                    if(condition_start_ball==false){
                        //System.out.println(imageView_ball.getTranslateY());

                        //Если происходит пересечение с верхней границей игрового поля
                        // (не проверяется, если пересечение было совершено за предыдущий шаг таймера анимации-
                        // нужно, чтобы не было застревания мячика в стенке)
                        if(imageView_ball.getTranslateY()<=y_up&&bool_y_up==true){
                            //Условие возможности пересечения с верхней стенкой ставится на false,
                            // а остальные- на true
                            bool_y_up=false;
                            bool_y_down=true;
                            bool_x_right=true;
                            bool_x_left=true;

                            //При пересечении с верхней стенкой
                            // шаг движения мячика по вертикали будет направлен вниз
                            y_by=abs(y_by);
                            //Остановка анимации мячика
                            translateTransition_ball.stop();
                            //Установка нового шага анимации по вертикали
                            translateTransition_ball.setByY(y_by);
                            //Установка  auto reverse value на false
                            translateTransition_ball.setAutoReverse(false);
                            //Начало работы анимации
                            translateTransition_ball.play();
                        }

                        //Если происходит пересечение с нижней границей игрового поля
                        // (не проверяется, если пересечение было совершено за предыдущий шаг таймера анимации-
                        // нужно, чтобы не было застревания мячика в стенке)

                        if(imageView_ball.getTranslateY()>=y_down-38&&bool_y_down==true){
                            //Условие возможности пересечения с нижней стенкой ставится на false,
                            // а остальные- на true

                            bool_y_up=true;
                            bool_y_down=false;
                            bool_x_right=true;
                            bool_x_left=true;

                            //При пересечении с нижней стенкой
                            // шаг движения мячика по вертикали будет направлен вверх


                            y_by=-abs(y_by);
                            //Остановка анимации мячика
                            translateTransition_ball.stop();
                            //Установка нового шага анимации по вертикали
                            translateTransition_ball.setByY(y_by);
                            //Установка  auto reverse value на false
                            translateTransition_ball.setAutoReverse(false);
                            //Начало работы анимации
                            translateTransition_ball.play();
                        }

                        //Если происходит пересечение с левой границей игрового поля
                        // (не проверяется, если пересечение было совершено за предыдущий шаг таймера анимации-
                        // нужно, чтобы не было застревания мячика в стенке)

                        if(imageView_ball.getTranslateX()<=x_left&&bool_x_left==true){
                            //Условие возможности пересечения с левой стенкой ставится на false,
                            // а остальные- на true

                            bool_y_up=true;
                            bool_y_down=true;
                            bool_x_right=true;
                            bool_x_left=false;

                            //При пересечении с левой стенкой
                            // шаг движения мячика по горизонтали будет направлен вправо


                            x_by=abs(x_by);
                            //Остановка анимации мячика
                            translateTransition_ball.stop();
                            //Установка нового шага анимации по горизонтали
                            translateTransition_ball.setByX(x_by);
                            //Установка  auto reverse value на false
                            translateTransition_ball.setAutoReverse(false);
                            //Начало работы анимации
                            translateTransition_ball.play();

                            //Условие проверки столкновения шарика с левой (красной) ракеткой
                            // (только по оси Y, т.к. пересечение с осью X проверяется условием выше)


                            if((imageView_ball.getTranslateY()<imageView_racketRed.getTranslateY()+30)&&(imageView_ball.getTranslateY()>=imageView_racketRed.getTranslateY()-120)){
                                //Отладка
                                System.out.println("WOW");

                                //Эмблемы хода красной (левой) и синей (правой) команд завершают анимацию
                                translateTransition_playRed.stop();
                                translateTransition_playBlue.stop();
                                //Установка движения для выхода за границу поля красной (левой) эмблемы
                                translateTransition_playRed.setToX(-500);
                                //Установка auto reverse value на false
                                translateTransition_ball.setAutoReverse(false);
                                //Запуск анимации красной (левой) эмблемы
                                translateTransition_playRed.play();
                                //Установка движения к центру поля синей (правой) эмблемы
                                translateTransition_playBlue.setToX(0);
                                //Установка  auto reverse value на false
                                translateTransition_ball.setAutoReverse(false);
                                //Запуск анимации синей (правой) эмблемы
                                translateTransition_playBlue.play();

                            }else{
                                play_condition=false;
                                //Остановка анимации мячика
                            translateTransition_ball.stop();

                                //Эмблемы хода красной (левой) и синей (правой) команд завершают анимацию
                                translateTransition_playRed.stop();
                                translateTransition_playBlue.stop();

                                //Эмблемы хода красной (левой) и синей (правой) команд уходят за границу поля
                                translateTransition_playRed.setToX(-500);
                                //Установка auto reverse value на false
                                translateTransition_ball.setAutoReverse(false);
                                translateTransition_playRed.play();
                                translateTransition_playBlue.setToX(500);
                                //Установка  auto reverse value на false
                                translateTransition_ball.setAutoReverse(false);
                                translateTransition_playBlue.play();


                                //Вывод картинки победы синей (правой) команды


                                //Установка координат перемещения с левой границы в центр экрана
                                translateTransition_teamBlue.setToX(-1000);
                                translateTransition_teamBlue.setToY((((700+210)-300)*2));

                                //Установка  auto reverse value на false
                                translateTransition_teamBlue.setAutoReverse(false);
                                translateTransition_teamBlue.play();
                            }
                        }

                        //Если происходит пересечение с правой границей игрового поля
                        // (не проверяется, если пересечение было совершено за предыдущий шаг таймера анимации-
                        // нужно, чтобы не было застревания мячика в стенке)

                        if(imageView_ball.getTranslateX()>=x_right-38&&bool_x_right==true){
                            //Условие возможности пересечения с правой стенкой ставится на false,
                            // а остальные- на true


                            bool_y_up=true;
                            bool_y_down=true;
                            bool_x_right=false;
                            bool_x_left=true;

                            //При пересечении с правой стенкой
                            // шаг движения мячика по горизонтали будет направлен влево


                            x_by=-abs(x_by);
                            //Остановка анимации мячика
                            translateTransition_ball.stop();
                            //Установка нового шага анимации по горизонтали
                            translateTransition_ball.setByX(x_by);
                            //Установка  auto reverse value на false
                            translateTransition_ball.setAutoReverse(false);
                            //Начало работы анимации
                            translateTransition_ball.play();


                            translateTransition_playRed.stop();
                            translateTransition_playBlue.stop();
                            //Creating Translate Transition
                            translateTransition_playRed.setToX(0);
                            //Установка  auto reverse value на false
                            translateTransition_ball.setAutoReverse(false);
                            translateTransition_playRed.play();
                            translateTransition_playBlue.setToX(500);
                            //Setting auto reverse value to false
                            translateTransition_ball.setAutoReverse(false);
                            translateTransition_playBlue.play();

                            //Условие проверки столкновения шарика с правой (синей) ракеткой
                            // (только по оси Y, т.к. пересечение с осью X проверяется условием выше)


                            if((imageView_ball.getTranslateY()<imageView_racketBlue.getTranslateY()+30)&&(imageView_ball.getTranslateY()>=imageView_racketBlue.getTranslateY()-120)){
                                //Отладка
                                System.out.println("WOW");
                            }else{
                                play_condition=false;
                                //Остановка анимации мячика
                            translateTransition_ball.stop();

                                //Эмблемы хода красной (левой) и синей (правой) команд завершают анимацию


                                translateTransition_playRed.stop();
                                translateTransition_playBlue.stop();
                                //Эмблемы хода красной (левой) и синей (правой) команд уходят за границу поля
                                translateTransition_playRed.setToX(-500);
                                //Установка  auto reverse value на false
                                translateTransition_playRed.setAutoReverse(false);
                                translateTransition_playRed.play();
                                translateTransition_playBlue.setToX(500);
                                //Установка  auto reverse value на false
                                translateTransition_playBlue.setAutoReverse(false);
                                translateTransition_playBlue.play();


                                //Вывод картинки победы красной (левой) команды


                                //Установка координат перемещения с правой границы в центр экрана
                                translateTransition_teamRed.setToX(1000);
                                translateTransition_teamRed.setToY(((700+210)-700)*2);

                                //Установка auto reverse value на false
                                translateTransition_teamRed.setAutoReverse(false);
                                translateTransition_teamRed.play();

                            }

                        }
                    }

                    //Условие нажатия клавиши клавиатуры Стрелки Влево
                    if(removeActiveKey("LEFT")){
                        //Отладка
                                System.out.println("left");
                    }

                    //Условие нажатия клавиши клавиатуры Стрелки Вправо

                    if(removeActiveKey("RIGHT")){
                        //Отладка
                                System.out.println("right");
                    }

                    //Условие нажатия клавиши клавиатуры Стрелки Вверх

                    if(removeActiveKey("UP")){
                        //Остановка анимации правой (синей) ракетки
                        translateTransition_racketBlue.stop();
                        //Уставовка движения правой (синей) ракетки вверх
                        translateTransition_racketBlue.setToY(-100-200/2);
                        //Установка  auto reverse value на false
                        translateTransition_racketBlue.setAutoReverse(false);
                        //Начало работы анимации
                        translateTransition_racketBlue.play();
                        //Отладка
                                System.out.println("up");
                    }

                    //Условие нажатия клавиши клавиатуры Стрелки Вниз

                    if(removeActiveKey("DOWN")){
                        //Остановка анимации правой (синей) ракетки
                        translateTransition_racketBlue.stop();
                        //Уставовка движения правой (синей) ракетки вниз
                        translateTransition_racketBlue.setToY(350-200/2);
                        //Установка  auto reverse value на false
                        translateTransition_racketBlue.setAutoReverse(false);
                        //Начало работы анимации
                        translateTransition_racketBlue.play();
                        //Отладка
                                System.out.println("down");
                    }

                    //Условие нажатия клавиши клавиатуры "W"

                    if(removeActiveKey("W")){

                        //Остановка анимации левой (красной) ракетки
                        translateTransition_racketRed.stop();
                        //if(imageView_racketRed.getY() != 100-200/2){
                        //Уставовка движения левой (красной) ракетки вверх
                        translateTransition_racketRed.setToY(-100-200/2);
                        //Установка  auto reverse value на false
                        translateTransition_racketRed.setAutoReverse(false);
                        //Начало работы анимации
                        translateTransition_racketRed.play();
                        //}
                        //Отладка
                                System.out.println("w");
                        //System.out.println(imageView_racketRed.getY());
                        //Отладка
                                System.out.println();

                    }

                    //Условие нажатия клавиши клавиатуры "S"

                    if(removeActiveKey("S")){
                        //Остановка анимации левой (красной) ракетки
                        translateTransition_racketRed.stop();
                        //if(imageView_racketRed.getY() != 300-200/2){
                        //Уставовка движения левой (красной) ракетки вниз
                        translateTransition_racketRed.setToY(350-200/2);
                        //Установка  auto reverse value на false
                        translateTransition_racketRed.setAutoReverse(false);
                        //Начало работы анимации
                        translateTransition_racketRed.play();
                        //}
                        //Отладка
                                System.out.println("s");



                    }

                    //Условие отжатия клавиши клавиатуры Стрелки Влево

                    if(removeActiveKey("LEFT-Released")){
                        //Отладка
                                System.out.println("left-Released");
                    }

                    //Условие отжатия клавиши клавиатуры Стрелки Вправо

                    if(removeActiveKey("RIGHT-Released")){
                        //Отладка
                                System.out.println("right-Released");
                    }

                    //Условие отжатия клавиши клавиатуры Стрелки Вверх

                    if(removeActiveKey("UP-Released")){
                        //Остановка анимации правой (синей) ракетки
                        translateTransition_racketBlue.stop();
                        //Отладка
                                System.out.println("up-Released");
                    }

                    //Условие отжатия клавиши клавиатуры Стрелки Вниз

                    if(removeActiveKey("DOWN-Released")){
                        //Остановка анимации правой (синей) ракетки
                        translateTransition_racketBlue.stop();
                        //Отладка
                                System.out.println("down-Released");
                    }

                    //Условие отжатия клавиши клавиатуры "W"

                    if(removeActiveKey("W-Released")){
                        //Остановка анимации левой (красной) ракетки
                        translateTransition_racketRed.stop();
                        //Отладка
                                System.out.println("w-Released");



                    }

                    //Условие отжатия клавиши клавиатуры "S"

                    if(removeActiveKey("S-Released")){
                        //Остановка анимации левой (красной) ракетки
                        translateTransition_racketRed.stop();
                        //Отладка
                                System.out.println("s-Released");

                    }


                }

            }
            //Запуск Сцены
        }.start();

        //Запуск отображения окна
        stage.show();
    }
//Проверка на нажатие и отжатие клавиши (и добавление в список)
    private boolean removeActiveKey(String codeString){
        Boolean isActive=currentlyActiveKeys.get(codeString);

        if(isActive!=null&&isActive){
            currentlyActiveKeys.put(codeString,false);
            return true;
        }else{
            return false;
        }
    }
    //////////


    public static void main(String args[]){
        launch(args);
    }
}