package data_structures

class DynamicArray(
    private var array: Array<String?> = arrayOfNulls(1),
    private var capacity: Int = 1,
    var length: Int = 0
) {
    // Push elements into the array - at the end
    fun push(element: String){
        if (length == capacity) {
            val tempArray = arrayOfNulls<String>(2 * capacity)
            for (i in array.indices) {
                tempArray[i] = array[i]
            }
            array = tempArray
            capacity *= 2
        }
        array[length] = element
        length++
    }

    // Remove last item of the array
    fun pop(){
        if (length > 0){
            length--
        }
    }

    // Replace a value at a given index
    fun replace(index: Int, value: String){
        if (index > -1 && index < length){
            array[index] = value
        }else{
            println("Index out of bound")
        }
    }

    // Delete element at a given index
    fun delete(index: Int){
        if (index > -1 && index < length){
            if (index == length -1){
                pop()
            }else {
                for (i in index until length){
                    array[i] = array[i+1]
                }
                length--
            }
        }else{
            println("Index out of bound")
        }
    }

    // Get element at a given index
    fun get(index: Int): String? {
        return if (index > -1 && index < length) {
            array[index]
        } else {
            "Index out of bound"
        }
    }

    // gets the array
    fun array(): Array<String?> {
        val tempArr = arrayOfNulls<String>(length)
        for (i in 0 until length) {
            tempArr[i] = array[i]
        }
        return tempArr
    }

}

fun main() {
    val dynamicArray = DynamicArray()
    dynamicArray.push("Audi")
    dynamicArray.push("Audi")
    dynamicArray.push("Audi")
    dynamicArray.push("Audi")
    dynamicArray.push("Audi")
    dynamicArray.push("Audi")

    dynamicArray.pop()



    println(dynamicArray.replace(2, "BMW"))
}