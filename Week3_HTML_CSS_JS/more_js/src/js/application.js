import TodoListComponent from './components/todo-list-component';
import TodoItem from './model/todo-item';
import TodoList from './model/todo-list';

class Application {
    constructor(){}

    run() {
        console.log("This application doesn't do anything");
    }
}

class TodoApp extends Application {
    constructor(root) {
        super(); //this must be done in the extending class's constructor
        this._lists = [new TodoList(1, [
            new TodoItem(1, 'Paint the fence', false),
            new TodoItem(2, 'Wax the car', false)
        ])];
        this._root = root;
    }

    run() {
        this.render();
    }

    render() {
        console.log('render app');
        const todoList = (new TodoListComponent(this._lists[0])).render();
        this._root.append(todoList);
    }
}


export {
    Application,
    TodoApp
}