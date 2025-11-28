package ru.levin.modules.combat;

import ru.levin.events.Event;
import ru.levin.manager.Manager;
import ru.levin.modules.Function;
import ru.levin.modules.FunctionAnnotation;
import ru.levin.modules.Type;
import ru.levin.modules.movement.Speed;
import ru.levin.modules.setting.BooleanSetting;
import ru.levin.modules.setting.ModeSetting;
import ru.levin.modules.setting.SliderSetting;

@FunctionAnnotation(name = "TargetStrafe", type = Type.Combat,desc = "Like in Nurik strafing yyy")
public class TargetStrafe extends Function {
    public final SliderSetting speedSlider = new SliderSetting("Speed",0.095f,0.01f,1.2f,0.01f);

    public final ModeSetting ptytag = new ModeSetting("Attraction Method","Vector","Vector","Motion / Velocity");
    public final SliderSetting blocks = new SliderSetting("Attraction Distance",7f,0.01f,12f,0.01f);
    public final SliderSetting hitbox = new SliderSetting("Hitbox for boost",0.095f,0.01f,50.0f,0.01f);
    public final BooleanSetting predictCheck = new BooleanSetting("Predict",true);
    public final SliderSetting predict = new SliderSetting("Predict Value",2.5f,0.1f,4.0f,0.1f,() -> predictCheck.get());

    public final BooleanSetting predictView = new BooleanSetting("See Predict",false,"For your screen, you will directly overtake the enemy");


    public TargetStrafe() {
        addSettings(speedSlider,ptytag,blocks,hitbox,predictCheck,predict,predictView);
    }

    @Override
    public void onEvent(Event event) {
    }
    @Override
    protected void onDisable() {
        if (mc.options.forwardKey.isPressed()) {
            mc.options.forwardKey.setPressed(false);
        }
        super.onDisable();
    }
    @Override
    public void onEnable() {
        Speed speed = Manager.FUNCTION_MANAGER.speed;
        if (speed.state) {
            speed.setState(false);
        }
        super.onEnable();
    }
}