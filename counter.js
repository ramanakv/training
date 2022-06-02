
import { createStore } from "redux";

const initialState={count:0}
const reducer= (state=initialState,action)=>{
    switch(action.type){
        case 'UP': return {...state,count:state.count+1 };
        case 'DOWN': return {...state,count:state.count-1};
        case'STEP': return {...state,count:state.count+action.value}
        default: return state
    }
}
const increment = ()=> {return  {type:'UP'}}

const decrement=()=> { return {type:'DOWN'}}    
const stepUp = (step)=>{
    return {
        type:'STEP',
        value:step
    }
}

let store = createStore(reducer);

let close=store.subscribe(()=>{console.log(store.getState())});

store.dispatch(increment())
store.dispatch(increment())
store.dispatch(decrement())
close();
store.dispatch(stepUp(6))
store.dispatch(stepUp(-2))


console.log(store.getState())