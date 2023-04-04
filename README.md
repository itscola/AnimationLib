# AnimationLib
An animation lib for Java. It can be used in various graphic animations.    

# Demo:
```java
protected Animation displayAnimation = new Animation();
protected Animation closeAnimation = new Animation();

displayAnimation.setMin(0).setMax(150).setFunction(new CubicOutFunction()).setTotalTime(260);
closeAnimation.setMin(150).setMax(0).setFunction(new CubicOutFunction()).setTotalTime(150);

if(!needClose){
    // The update method will return the max value, after the total time.
    Render2DUtils.drawRect(x , y , x1, displayAnimation.update());
    
}else{
    Render2DUtils.drawRect(x , y , x1, closeAnimation.update());
}


if(displayAnimation.isFinish()){
    // displayAnimation is finish.
}


displayAnimation.reset();

```


```java
protected Animation displayAnimation = new Animation();
protected long time;

displayAnimation.setMin(0).setMax(150).setFunction(new CubicOutFunction()).setTotalTime(260);

//init
this.time = System.currentTimeMillis()


Render2DUtils.drawRect(x , y , x1, closeAnimation.update(System.currentTimeMillis() - this.time));

```



```java
protected Animation displayAnimation = new Animation();

Render2DUtils.drawRect(x , y , x1, 
displayAnimation.setMin(0).setMax(150).setFunction(new CubicOutFunction()).setTotalTime(260).setLock(true).update()
);


```

```java
float value = enableAnimation.update();
   if(!enableAnimation.isFinish()){
   yPosition = 16 + value;
}
```


