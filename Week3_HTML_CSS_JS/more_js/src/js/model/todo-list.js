class TodoList {
    constructor(id, todos) {
        this._todos = todos || [];
        this.id = id
    }

    get todos() {
        return this._todos;
    }

    set todos(todos) {
        if(todos.length) {
            this._todos = todos;
        } else {
            this._todos = [];
        }
    }

}

export default TodoList;