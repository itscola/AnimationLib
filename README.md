# AnimationLib
An animation lib for Java. It can be used in various graphic animations.    

# Demo:
```java
protected Animation displayAnimation = new Animation();
protected Animation closeAnimation = new Animation();

displayAnimation.setMin(0).setMax(150).setFunction(new CubicOutFunction()).setTotalTime(260);
closeAnimation.setMin(150).setMax(0).setFunction(new CubicOutFunction()).setTotalTime(150);

if(!isNeedClose){
    // The update method will return the max value, after the total time.
    Render2DUtils.drawRect(x , y , x1, displayAnimation.update());
    
}else{
    Render2DUtils.drawRect(x , y , x1, closeAnimation.update());
}


if(displayAnimation.isFinish()){
    // displayAnimation is finished.
}


displayAnimation.reset();

```


# License
This project is subject to the [GNU General Public License v3.0](LICENSE). This does only apply for source code located directly in this clean repository. During the development and compilation process, additional source code may be used to which we have obtained no rights. Such code is not covered by the GPL license.

For those who are unfamiliar with the license, here is a summary of its main points. This is by no means legal advise nor legally binding.

You are allowed to
- use
- share
- modify

this project entirely or partially for free and even commercially. However, please consider the following:

- **You must disclose the source code of your modified work and the source code you took from this project. This means you are not allowed to use code from this project (even partially) in a closed-source (or even obfuscated) application.**
- **Your modified application must also be licensed under the GPL** 

Do the above and share your source code with everyone; just like we do.

## Other
If used, keep the package name (top.whitecola.animationlib).


