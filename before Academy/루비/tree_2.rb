class Tree
    attr_accessor :children, :node_name

    def initialize args
        args.each do |k,v|
          instance_variable_set("@#{k}", v) unless v.nil?
        end
      end

    def visit_all(&block)
        visit &block
        children.each {|c| c.visit_all &block}
    end

    def visit(&block)
        block.call self
    end
end

Tree.new({'grandpa'=>{'dad'=>{'c1'=>{},'c2'=>{}},
    'uncle'=>{'c3'=>{},'c4'=>{}}}})