// Converting a function with multiple parameters to curried form

def add = (x:Int, y: Int) => x + y
val addCurried = add.curried
println(add(5,6))
println(addCurried(5)(6))


// 11
// 11


val addCurriedUncurried = Function.uncurried(addCurried)
println(addCurriedUncurried(5,6))


// 11
