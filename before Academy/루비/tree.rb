class Tree
    attr_accessor :children, :node_name

    def initialize(name,children=[])
        @children = children
        @node_name = name
    end

    def visit_all(&block)
        visit &block
        children.each {|c| c.visit_all &block}
    end

    def visit(&block)
        block.call self
    end
end

ruby_tree =Tree.new("grandpa",
    [Tree.new("dad",[Tree.new("child1"),Tree.new("child2")]),
    Tree.new("Uncle",[Tree.new("child3"),Tree.new("child4")])
])

ruby_tree.visit_all {|a| puts a.node_name}
ruby_tree.visit{|a| puts a.node_name}