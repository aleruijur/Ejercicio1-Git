array = []

function add(){
    let num = parseInt(newElem.value)
    if(!isNaN(num)){
        array.push(num)
    }

    newElem.value=""
    res.value = array
}

function ranDelete(){
    let ran = Math.random()
    let i = Math.round(ran * (array.length-1))
    array.splice(i,1)

    res.value = array
}