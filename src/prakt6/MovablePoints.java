package prakt6;

public class MovablePoints {
    Point up_left_point;
    Point down_right_point;

    public MovablePoints ( int _current_up_left_x,
                           int _current_up_left_y,
                           int _last_up_left_x,
                           int _last_up_left_y,
                           int _current_down_right_x,
                           int _current_down_right_y,
                           int _last_down_right_x,
                           int _last_down_right_y){
        new Point(_current_up_left_x,_current_up_left_y,_last_up_left_x,_last_up_left_y);
        new Point(_current_down_right_x,_current_down_right_y,_last_down_right_x,_last_down_right_y);
    }

    public void move(int up_left_x, int up_left_y, int down_right_x, int down_right_y){
        up_left_point.last_x = up_left_point.current_x;
        up_left_point.last_y = up_left_point.current_y;
        up_left_point.current_x = up_left_x;
        up_left_point.current_y = up_left_y;
        down_right_point.last_x = down_right_point.current_x;
        down_right_point.last_y = down_right_point.current_y;
        down_right_point.current_x = down_right_x;
        down_right_point.current_y = down_right_y;
    }

    public boolean isSpeed(){

        return ( ( ( up_left_point.current_x - up_left_point.last_x ) == ( down_right_point.current_x - down_right_point.last_x ) ) && ( ( up_left_point.current_y - up_left_point.last_y ) == ( down_right_point.current_y - down_right_point.last_y ) ) );
    }
}
