class Solution {
public:
    double angleClock(int hour, int minutes) {
        
        if (hour == 12) {
            
            hour = 0;
        }
        
        float hour_min = (hour*5) + (minutes*2.5)/30;
        
        float val = abs(hour_min - minutes) * 6;
        
        float angle = std::min(val, 360-val);
        
        float roundedAngle = std::round(angle * 10.0) / 10.0;
        
        return roundedAngle;
          
    }
};
